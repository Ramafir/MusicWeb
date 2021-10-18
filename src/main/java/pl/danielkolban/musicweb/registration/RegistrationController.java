package pl.danielkolban.musicweb.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.danielkolban.musicweb.user.User;
import pl.danielkolban.musicweb.user.UserService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class RegistrationController {

    UserService userService;


    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "security/register";
    }

    @PostMapping("/register/save")
    public String saveUser(Model model, @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return "security/register";
        }
        userService.signUpUser(user);
        return "redirect:/";

    }
}
