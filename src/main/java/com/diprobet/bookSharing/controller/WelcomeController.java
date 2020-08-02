package com.diprobet.bookSharing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String welcome(ModelMap modelMap) {
        modelMap.put("message", "Welcome");

        return "welcome";
    }
}
