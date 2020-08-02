package com.diprobet.bookSharing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/logout")
public class LogoutController {

    @RequestMapping(method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:http://localhost:8080/login";
    }
}
