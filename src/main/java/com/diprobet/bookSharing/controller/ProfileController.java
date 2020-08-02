package com.diprobet.bookSharing.controller;

import com.diprobet.bookSharing.entity.Transaction;
import com.diprobet.bookSharing.entity.User;
import com.diprobet.bookSharing.service.BookService;
import com.diprobet.bookSharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String viewProfile(ModelMap modelMap, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        List<Transaction> List = bookService.requestedBookListOfIndividualUser(user.getUserId());

        modelMap.put("user", user);
        modelMap.put("list", List);

        return "profile";
    }

    @RequestMapping(value = "editProfile", method = RequestMethod.GET)
    public String viewEditProfilePage(@RequestParam("userId") int userId, ModelMap modelMap) {

        User user = userService.findUser(userId);
        modelMap.put("user", user);
        setupReferenceData(modelMap);

        return "editProfile";
    }

    @RequestMapping(value = "editProfile", method = RequestMethod.POST)
    public String saveEditProfile(@ModelAttribute User user) {
        userService.updateUserInformation(user);

        return "redirect:http://localhost:8080/profile?userId=" + user.getUserId();
    }

    private void setupReferenceData(ModelMap modelMap) {
        modelMap.put("userTypeOptionList", new ArrayList<>(Arrays.asList("Admin", "User")));
    }

}
