package planner;

import java.util.ArrayList;
import java.util.Set;
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
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import navigation.SideBarModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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

    @Autowired
    private LoginRepository loginRepo;
    @Autowired
    private RegistrationService regService;
    @Autowired
    private RequestRepository requestRepo;

    private ArrayList<SideBarModel> getNavigation() {
        ArrayList<SideBarModel> navigations = new ArrayList<>();
        navigations.add(new SideBarModel("Home", "/home"));
        navigations.add(new SideBarModel("Login", "/"));
        navigations.add(new SideBarModel("Request Days Off", "/request"));
        navigations.add(new SideBarModel("Requests Status", "/status"));
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        LoginModel userNameModel = loginRepo.findByUserName(name);
        Set<RoleModel> roleModels = userNameModel.getRoles();
        for (RoleModel role : roleModels) {
            if ("ADMIN".equals(role.getName())) {
                navigations.add(new SideBarModel("Register", "/register"));
                navigations.add(new SideBarModel("Edit user", "/edit"));
                navigations.add(new SideBarModel("Show holiday requests", "/openrequests"));
            }
        }
        return navigations;
    }

    @GetMapping("/home")
    public String showIndex(Model model) {
        model.addAttribute("SideBarModel", getNavigation());
        return "index";
    }

    @GetMapping("/")
    public String showLoginForm(Model model) {
        model.addAttribute("LoginModel", new LoginModel());
        return "login";
    }

    @GetMapping("/login")
    public String showLoginFormAgain(Model model) {
        model.addAttribute("LoginModel", new LoginModel());
        return "login";
    }

    @GetMapping("/register")
    public String showRegForm(Model model) {
        model.addAttribute("SideBarModel", getNavigation());
        model.addAttribute("LoginModel", new LoginModel());
        return "user";
    }

    @GetMapping("/request")
    public String showRequestForm(Model model) {
        model.addAttribute("SideBarModel", getNavigation());
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
        if (bindingResult.hasErrors()) {
            return "user";
        }
        if (loginRepo.findByUserName(reg.getUserName()) != null) {
            bindingResult.addError(new ObjectError("UsernameExists", "This username already exists, please chose another"));
            return "user";
        }
        if (reg.getPassWord().equals(reg.getPasswordVerify())) {
            regService.Save(new LoginModel(reg.getPassWord(), reg.getUserName(), reg.getDaysOff()));
            return "redirect:/login";
        } else {
            bindingResult.addError(new ObjectError("PasswordFail", "Please enter matching passwords"));
            return "user";
        }
    }

    @GetMapping("/edit")
    public String showEditForm(Model model) {
        model.addAttribute("SideBarModel", getNavigation());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        model.addAttribute("LoginModel", loginRepo.findByUserName(userName));
        return "edit";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("LoginModel") @Valid LoginModel reg, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }

        LoginModel oldUser = loginRepo.findByUserName(reg.getUserName());
        oldUser.setUserName(reg.getUserName());
        oldUser.setDaysOff(reg.getDaysOff());
        oldUser.setPassWord(reg.getPassWord());

        regService.Save(oldUser);

        return "edit";
    }

    @GetMapping("/openrequests")
    public String getRequests(Model model) {
        model.addAttribute("SideBarModel", getNavigation());
        model.addAttribute("requests", requestRepo.findByStatus(0));
        return "openrequests";
    }

    @GetMapping("/status")
    public String showStatus(Model model) {
        LoginModel currentUser = getLoggedInUser();
        model.addAttribute("SideBarModel", getNavigation());
        model.addAttribute("requests", requestRepo.findByRequestor(currentUser));
        return "status";
    }

    @RequestMapping("/openrequests/accept/")
    public String acceptHoliday(@RequestParam("id") long id, Model model) {
        LoginModel currentUser = getLoggedInUser();
        for (RoleModel role : currentUser.getRoles()) {
            if ("ADMIN".equals(role.getName())) {
                RequestModel toEdit = requestRepo.findOne(id);
                toEdit.setStatus(StatusEnum.APPROVED);
                requestRepo.save(toEdit);
            }
        }
        model.addAttribute("requests", requestRepo.findByRequestor(currentUser));
        return "redirect:/openrequests";
    }

    @RequestMapping("/openrequests/deny/")
    public String denyHoliday(@RequestParam("id") long id, Model model) {
        LoginModel currentUser = getLoggedInUser();
        for (RoleModel role : currentUser.getRoles()) {
            if ("ADMIN".equals(role.getName())) {
                RequestModel toEdit = requestRepo.findOne(id);
                toEdit.setStatus(StatusEnum.DECLINED);
                requestRepo.save(toEdit);
            }
        }
        model.addAttribute("requests", requestRepo.findByRequestor(currentUser));
        return "redirect:/openrequests";
    }

    private LoginModel getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return loginRepo.findByUserName(auth.getName());
    }
}
