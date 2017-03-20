package planner;

import security.repo.LoginRepository;
import security.model.Login;
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
import security.model.RequestModel;

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
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/secret").setViewName("secret");
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @GetMapping("/register")
    public String showRegForm(Login reg, BindingResult bindingResult) {
        return "user";
    }
    
    @GetMapping("/request")
    public String showRequestForm(Model model) {
        model.addAttribute("request", new RequestModel());
        return "request";
    }
    
    @PostMapping("/request")
    public String sendRequest(@Valid RequestModel reg, BindingResult bindingResult) {
        
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors().toString());
            return "request";
        }
        
        else{
            return "request";    
        }
       
    }
    
    @PostMapping("/register")
    public String register(@Valid Login reg, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user";
        }
        if (loginRepo.findByUserName(reg.getUserName()) != null) {
            bindingResult.addError(new ObjectError("UsernameExists", "This username already exists, please chose another"));
            return "user";
        }
        if (reg.getPassWord().equals(reg.getPasswordVerify())) {
            regService.Save(new Login(reg.getPassWord(), reg.getUserName(), reg.getDaysOff()));
            return "redirect:/secret";
        } else {
            bindingResult.addError(new ObjectError("PasswordFail", "Please enter matching passwords"));
            return "user";
        } 
   }
}
