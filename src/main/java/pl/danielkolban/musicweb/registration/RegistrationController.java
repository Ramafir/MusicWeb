package pl.danielkolban.musicweb.registration;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.danielkolban.musicweb.security.PasswordEncoder;
import pl.danielkolban.musicweb.user.User;
import pl.danielkolban.musicweb.user.UserRepository;
import pl.danielkolban.musicweb.user.UserService;

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
    public String saveUser(Model model, User user) {
        userService.signUpUser(user);
        return "redirect:/";

    }
}
