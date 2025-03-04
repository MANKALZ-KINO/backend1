package com.example.backend.controllers;

import com.example.backend.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/")
    public String viewFrontpage(Model model) {
        model.addAttribute("url", "/portfolio");
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpSession session,
                        @RequestParam String username,
                        @RequestParam String password,
                        @RequestParam String url,
                        Model model) {
        boolean passwordCorrect = false;
        boolean usernameCorrect = true;
        try {
            passwordCorrect = LoginService.login(username, password);
        } catch (EmptyResultDataAccessException e) {
            usernameCorrect = false;
        }
        if (usernameCorrect && passwordCorrect) {
            session.setAttribute("userProfile", loginService.readUserProfile(username));
            return "redirect:" + url;
        }
        model.addAttribute("message", usernameCorrect ? "Invalid password." : "Invalid username.");
        model.addAttribute("username", username);
        model.addAttribute("url", url);
        return "login";
    }

}
