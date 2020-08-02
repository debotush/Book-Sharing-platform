package com.diprobet.bookSharing.controller;


import com.diprobet.bookSharing.entity.User;
import com.diprobet.bookSharing.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(method = GET)
    public String view(ModelMap modelMap) {
        User user = new User();

        modelMap.put("user", user);
        modelMap.put("userTypeOptionList", new ArrayList<>(Arrays.asList("Admin", "User")));

        return "login";
    }

    @RequestMapping(method = POST)
    public String save(@ModelAttribute User user,
                       BindingResult bindingResult,
                       ModelMap modelMap,
                       HttpSession session) {
        user = userService.userLoginOrNot(user.getUserName(), user.getUserPassword(), user.getUserType());

        if (Objects.isNull(user)) {
            ObjectError objectError = new ObjectError("username", "User name or password is invalid");
            bindingResult.addError(objectError);
        }

        if (bindingResult.hasErrors()) {
            modelMap.put("error",bindingResult);
            modelMap.put("userTypeOptionList", new ArrayList<>(Arrays.asList("Admin", "User")));
            return "login";
        } else {
            session.setAttribute("currentUser", user);
        }
        return "redirect:http://localhost:8080/profile";
    }
}
