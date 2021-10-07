package pl.danielkolban.musicweb.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.danielkolban.musicweb.security.PasswordEncoder;
import pl.danielkolban.musicweb.user.User;
import pl.danielkolban.musicweb.user.UserService;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "security/register";
    }

    @PostMapping("/register/save")
    public String saveUser(Model model, User user) {
        user.setPassword(passwordEncoder.bCryptPasswordEncoder().encode(user.getPassword()));
        userService.signUpUser(user);
        return "redirect:/";

    }
}
