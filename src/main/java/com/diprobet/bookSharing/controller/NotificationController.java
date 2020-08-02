package com.diprobet.bookSharing.controller;


import com.diprobet.bookSharing.dto.Notification;
import com.diprobet.bookSharing.entity.User;
import com.diprobet.bookSharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
public class NotificationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "notifications", method = RequestMethod.GET)
    public List<Notification> getNotificationList(HttpSession session) {

        User currentUser = (User) session.getAttribute("currentUser");

        return Objects.nonNull(currentUser) ? userService.getNotificationList(currentUser.getUserId())
                : Collections.emptyList();
    }

    @RequestMapping(value = "acknowledge")
    public void sendAcknowledgement(@RequestParam int notificationId) {
        userService.notificationAcknowledgement(notificationId);
    }

}
