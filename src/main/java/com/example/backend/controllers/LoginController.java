package com.example.backend.controllers;

import com.example.backend.service.LoginService;
import org.springframework.stereotype.Controller;

@Controller

public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

}
