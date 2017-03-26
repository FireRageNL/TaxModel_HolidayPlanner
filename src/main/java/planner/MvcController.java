package planner;

import java.util.ArrayList;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import security.repo.LoginRepository;
import security.model.LoginModel;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import navigation.SideBarModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import security.model.RequestModel;
import security.model.RoleModel;
import security.model.StatusEnum;
import security.repo.RequestRepository;

/**
 *
 * @author Stijn
 */
@Controller
@EnableJpaRepositories(basePackages = "security.model")
@EntityScan(basePackages = "security.repo")
public class MvcController extends WebMvcConfigurerAdapter {

    private static final String ADMIN = "ADMIN";
    private static final String SIDEBAR = "SideBarModel";
    private static final String REQUESTS = "requests";
    private static final String LOGINMODEL = "LoginModel";
    @Autowired
    private LoginRepository loginRepo;
    @Autowired
    private RegistrationService regService;
    @Autowired
    private RequestRepository requestRepo;

    private ArrayList<SideBarModel> getNavigation() {
        ArrayList<SideBarModel> navigations = new ArrayList<>();
        navigations.add(new SideBarModel("Home", "/home"));
        navigations.add(new SideBarModel("Logout", "/logout"));
        navigations.add(new SideBarModel("Request Days Off", "/request"));
        navigations.add(new SideBarModel("Requests Status", "/status"));
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        LoginModel userNameModel = loginRepo.findByUserName(name);
        Set<RoleModel> roleModels = userNameModel.getRoles();
        for (RoleModel role : roleModels) {
            if (ADMIN.equals(role.getName())) {
                navigations.add(new SideBarModel("Register", "/register"));
                navigations.add(new SideBarModel("Edit user", "/edituser"));
                navigations.add(new SideBarModel("Show holiday requests", "/openrequests"));
            }
        }
        return navigations;
    }

    @GetMapping("/edituser")
    public String showUserList(Model model) {
        model.addAttribute(SIDEBAR, getNavigation());
        model.addAttribute("users", loginRepo.findAll());
        return "useroverview";
    }

    @GetMapping("/home")
    public String showIndex(Model model) {
        model.addAttribute(SIDEBAR, getNavigation());
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        LoginModel userNameModel = loginRepo.findByUserName(name);
        Set<RoleModel> roleModels = userNameModel.getRoles();
        for (RoleModel role : roleModels) {
            if (ADMIN.equals(role.getName()) && (requestRepo.findByStatus(0)!= null)) {
                int newRequests = requestRepo.findByStatus(0).size();
                String notification = "There are " + newRequests + " new requests";
                model.addAttribute("Notifications", notification);
            }
        }
        return "index";
    }

    @GetMapping("/")
    public String showLoginForm(Model model) {
        model.addAttribute(LOGINMODEL, new LoginModel());
        return "login";
    }

    @GetMapping("/login")
    public String showLoginFormAgain(Model model) {
        model.addAttribute(LOGINMODEL, new LoginModel());
        return "login";
    }

    @GetMapping("/register")
    public String showRegForm(Model model) {
        model.addAttribute(SIDEBAR, getNavigation());
        model.addAttribute(LOGINMODEL, new LoginModel());
        return "user";
    }

    @GetMapping("/request")
    public String showRequestForm(Model model) {
        model.addAttribute(SIDEBAR, getNavigation());
        model.addAttribute("RequestModel", new RequestModel());
        return "request";
    }

    @PostMapping("/request")
    public String sendRequest(@ModelAttribute("RequestModel") @Valid RequestModel reg, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "request";
        }

        if (reg.getEndDate().before(reg.getStartDate())) {
            bindingResult.addError(new ObjectError("endDateBeforeStart", "The selected end date is before the start date, please choose another end date."));
            return "request";
        } else {
            String userName = SecurityContextHolder.getContext().getAuthentication().getName();
            reg.setRequestor(loginRepo.findByUserName(userName));
            requestRepo.save(reg);
            return "redirect:/status";
        }

    }

    @PostMapping("/register")
    public String register(@ModelAttribute("LoginModel") @Valid LoginModel reg, BindingResult bindingResult) {

        if (loginRepo.findByUserName(reg.getUserName()) != null) {
            bindingResult.addError(new ObjectError("UsernameExists", "This username already exists, please chose another"));
            return "user";
        }
        if (reg.getPassWord().length() < 4) {
            bindingResult.addError(new ObjectError("PasswordFail", "Please enter a password longer than 4 characters"));
        }
        if (bindingResult.hasErrors()) {
            return "user";
        }
        if (reg.getPassWord().equals(reg.getPasswordVerify())) {
            regService.saveUser(new LoginModel(reg.getPassWord(), reg.getUserName(), reg.getDaysOff()));
            return "redirect:/login";
        } else {
            bindingResult.addError(new ObjectError("PasswordFail", "Please enter matching passwords"));
            return "user";
        }
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") long id, Model model) {
        model.addAttribute(SIDEBAR, getNavigation());
        model.addAttribute(LOGINMODEL, loginRepo.findOne(id));
        model.addAttribute("uid", id);
        return "edit";
    }

    @PostMapping("/edit")
    public String editUser(@RequestParam("id") long id, @ModelAttribute("LoginModel") @Valid LoginModel reg, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        LoginModel oldUser = loginRepo.findOne(id);
        oldUser.setUserName(reg.getUserName());
        oldUser.setDaysOff(reg.getDaysOff());
        if (reg.getPassWord().length() > 3) {
            oldUser.setPassWord(reg.getPassWord());
            regService.editUser(oldUser, true);
        } else {
            regService.editUser(oldUser, false);
        }
        return "redirect:/edituser";
    }

    @GetMapping("/openrequests")
    public String getRequests(Model model) {
        model.addAttribute(SIDEBAR, getNavigation());
        model.addAttribute(REQUESTS, requestRepo.findByStatus(0));
        return "openrequests";
    }

    @GetMapping("/status")
    public String showStatus(Model model) {
        LoginModel currentUser = getLoggedInUser();
        model.addAttribute(SIDEBAR, getNavigation());
        model.addAttribute(REQUESTS, requestRepo.findByRequestor(currentUser));
        return "status";
    }

    @RequestMapping("/openrequests/accept/")
    public String acceptHoliday(@RequestParam("id") long id, Model model) {
        LoginModel currentUser = getLoggedInUser();
        for (RoleModel role : currentUser.getRoles()) {
            if (ADMIN.equals(role.getName())) {
                RequestModel toEdit = requestRepo.findOne(id);
                toEdit.setStatus(StatusEnum.APPROVED);
                requestRepo.save(toEdit);
            }
        }
        model.addAttribute(REQUESTS, requestRepo.findByRequestor(currentUser));
        return "redirect:/openrequests";
    }

    @RequestMapping("/openrequests/deny/")
    public String denyHoliday(@RequestParam("id") long id, Model model) {
        LoginModel currentUser = getLoggedInUser();
        for (RoleModel role : currentUser.getRoles()) {
            if (ADMIN.equals(role.getName())) {
                RequestModel toEdit = requestRepo.findOne(id);
                toEdit.setStatus(StatusEnum.DECLINED);
                requestRepo.save(toEdit);
            }
        }
        model.addAttribute("requests", requestRepo.findByRequestor(currentUser));
        return "redirect:/openrequests";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    private LoginModel getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return loginRepo.findByUserName(auth.getName());
    }
}
