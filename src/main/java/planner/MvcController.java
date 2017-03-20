package planner;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ModelAttribute;

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
    
    @GetMapping("/")
    public String showIndex(Model model){
        ArrayList<SideBarModel> navigations = new ArrayList<SideBarModel>();
        navigations.add(new SideBarModel("Home", "/"));
        navigations.add(new SideBarModel("Login", "/login"));
        navigations.add(new SideBarModel("Register", "/register"));
        model.addAttribute("SideBarModel", navigations);
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("LoginModel", new LoginModel());
        return "login";
    }

    @GetMapping("/register")
    public String showRegForm(Model model) {
        model.addAttribute("LoginModel", new LoginModel());
        return "user";
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
}
