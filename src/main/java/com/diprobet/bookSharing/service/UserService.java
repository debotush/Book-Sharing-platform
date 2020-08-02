package com.diprobet.bookSharing.service;

import com.diprobet.bookSharing.dto.BookContribution;
import com.diprobet.bookSharing.dto.Notification;
import com.diprobet.bookSharing.entity.Book;
import com.diprobet.bookSharing.entity.Transaction;
import com.diprobet.bookSharing.entity.User;

import java.util.List;

public interface UserService {

    List<User> allUserList();
    void deleteUser(int userId);
    void userRegistration(User user);
    void updateUserInformation(User user);
    User findUser(int userId);
    User userLoginOrNot(String userName, String userPassword, String userType);
    List<BookContribution> topContributor(int howMany);
    void sendNotification(Notification notification);
    void notificationAcknowledgement(int notificationId);
    List<Notification> getNotificationList(int userId);
}
