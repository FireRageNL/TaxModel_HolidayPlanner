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
import security.model.RequestModel;
import security.model.RoleModel;

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

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/secret").setViewName("secret");
    }
    
    @GetMapping("/home")
    public String showIndex(Model model){
        ArrayList<SideBarModel> navigations = new ArrayList<>();
        
        navigations.add(new SideBarModel("Home", "/home"));
        navigations.add(new SideBarModel("Login", "/"));
        navigations.add(new SideBarModel("Request days off", "/request"));
        
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        LoginModel userNameModel = loginRepo.findByUserName(name);
        Set<RoleModel> roleModels = userNameModel.getRoles();
        for(RoleModel role : roleModels){
            if(role.getName().equals("ADMIN")){
                navigations.add(new SideBarModel("Register", "/register"));
            }
        }
        model.addAttribute("SideBarModel", navigations);
        return "index";
    }

    @GetMapping("/")
    public String showLoginForm(Model model) {
        model.addAttribute("LoginModel", new LoginModel());
        return "login";
    }

    @GetMapping("/register")
    public String showRegForm(Model model) {
        model.addAttribute("LoginModel", new LoginModel());
        return "user";
    }
    
    @GetMapping("/request")
    public String showRequestForm(Model model) {
        model.addAttribute("RequestModel", new RequestModel());
        return "request";
    }
    
    @PostMapping("/request")
    public String sendRequest(@ModelAttribute("RequestModel") @Valid RequestModel reg, BindingResult bindingResult) {
        System.out.println(reg.getStartDate());
        System.out.println(reg.getEndDate());
        
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors().toString());
            return "request";
        }
        
        else{
            return "request";    
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
            return "redirect:/secret";
        } else {
            bindingResult.addError(new ObjectError("PasswordFail", "Please enter matching passwords"));
            return "user";
        } 
   }
    
   @GetMapping("/edit")
   public String showEditForm(Model model) {
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
}
