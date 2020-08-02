package com.diprobet.bookSharing.dao;

import com.diprobet.bookSharing.dto.BookContribution;
import com.diprobet.bookSharing.dto.Notification;
import com.diprobet.bookSharing.entity.User;
import com.diprobet.bookSharing.util.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> allUserList() {
        List<User>userList = jdbcTemplate.query("SELECT * FROM user",new AdminRawMapper());
        return userList;
    }

    @Override
    public void deleteUser(int userId) {
        jdbcTemplate.update("DELETE FROM user WHERE userId = ?",new Object[]{userId});
    }

    @Override
    public void userRegistration(User user) {
        jdbcTemplate.update("INSERT INTO user(fullname,userName, userPassword, UserMail, userContact, userType) " +
                "VALUES (? , ? , ? , ? , ? , ?)", user.getFullName(), user.getUserName(), user.getUserPassword(),
                user.getUserMail(), user.getUserContact(), user.getUserType());
        System.out.println("Registration Complete for " + user.getUserName());
    }

    @Override
    public void updateUserInformation(User user) {
        jdbcTemplate.update("UPDATE  user  SET fullName = ? , userName = ? , userPassword = ? , userMail = ?, " +
                "userContact = ? , userType = ? WHERE userId = ?", user.getFullName(), user.getUserName(),
                user.getUserPassword(), user.getUserMail(), user.getUserContact(), user.getUserType(), user.getUserId());
    }

    @Override
    public User findUser(int userId) {
        try {
            String query = "SELECT * FROM user WHERE userId = ?";
            return jdbcTemplate.queryForObject(query, new Object[]{userId}, new AdminRawMapper());
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public User userLoginOrNot(String userName, String userPassword, String userType) {
        try {
            String query = "SELECT * FROM user WHERE userName = ? AND userPassword = ? AND userType = ?";
            return jdbcTemplate.queryForObject(query, new Object[]{userName, userPassword, userType}, new UserRowMapper());
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<BookContribution> topContributor(int howMany) {
        String sql = "SELECT u.fullName fullName, u.userName userName, COUNT(bookId) bookCount FROM user u JOIN book bk ON " +
                "(u.userId = bk.uploaderId) GROUP BY bk.uploaderId ORDER BY COUNT(bk.uploaderId) DESC LIMIT ?";

        return jdbcTemplate.query(sql,new Object[]{howMany},new BookContributionRowMapper());
    }

    @Override
    public void sendNotification(Notification notification) {
        String  sql = "INSERT INTO notification(massage, acknowledgement, notificationType, notificationTo, bookId)" +
                " VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,new Object[]{notification.getMessage(), notification.isAcknowledgement(),
                notification.getType(), notification.getNotificationTo().getUserId(), notification.getBook().getBookId()});
    }

    public void notificationAcknowledgement(int notificationId) {
        String sql = "UPDATE notification SET acknowledgement = ? WHERE notificationId = ?";

        jdbcTemplate.update(sql, new Object[]{1, notificationId});

    }

    public List<Notification> getNotificationList(int userId) {
        String sql = "SELECT  n.notificationId notificationId, n.massage massage, n.notificationType notificationType, n.bookId bookId FROM " +
                "notification n WHERE n.notificationTo = ? AND n.acknowledgement = ?";

        return jdbcTemplate.query(sql, new Object[]{userId, 0}, new NotificationRowMapper());
    }

}
