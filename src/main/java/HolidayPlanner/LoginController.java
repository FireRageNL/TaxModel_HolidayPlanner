package HolidayPlanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author Stijn
 */
@Controller
public class LoginController extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    @GetMapping("/login")
    public String showForm(Model model) {
        model.addAttribute("login",new Login());
        return "login";
    }

    @PostMapping("/login")
    public String greetingSubmit(@ModelAttribute Login login) {
        return "index";
    }
}
