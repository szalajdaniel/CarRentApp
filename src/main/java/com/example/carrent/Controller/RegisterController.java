package com.example.carrent.Controller;

import com.example.carrent.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register() {
        return "register_page";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password,
                           @RequestParam String firstName, @RequestParam String lastName,
                           @RequestParam String email, @RequestParam(required = false) String role, RedirectAttributes redirectAttributes,
                           HttpSession session) {

        if (userService.userExists(username)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Użytkownik o podanej nazwie już istnieje.");
            return "redirect:/register";
        }

        if (userService != null) {
            userService.register(username, password, firstName, lastName, email, role);
        }

        session.setAttribute("username", username);

        redirectAttributes.addFlashAttribute("successMessage", "Rejestracja udana!");
        redirectAttributes.addFlashAttribute("successMessage2", "Za chwilę zostaniesz przekierowany na stronę logowania.");

        return "redirect:/register/success";
    }

    @GetMapping("/register/success")
    public String success() {
        return "register_success_page";
    }
}

