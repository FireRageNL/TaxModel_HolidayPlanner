package planner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author Stijn
 */
@Controller
public class MvcController extends WebMvcConfigurerAdapter {
    
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
    public String showRegForm(Model model) {
        model.addAttribute("Register", new Register());
        return "Register";
    }

    @PostMapping("/register")
    public String register(Register reg) {
        if (reg.getPassWord().equals(reg.getPasswordVerify())) {
            regService.Save(new Login(reg.getPassWord(), reg.getUserName()));
            return "redirect:/secret";
        }
        return "redirect:/register";
    }
}
