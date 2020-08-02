package com.diprobet.bookSharing.util;

import com.diprobet.bookSharing.dto.Notification;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NotificationRowMapper implements RowMapper<Notification> {

    @Override
    public Notification mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Notification notification = new Notification();

        notification.setNotificationId(resultSet.getInt("notificationId"));
        notification.getBook().setBookId(resultSet.getInt("bookId"));
        notification.setMessage(resultSet.getString("massage"));
        notification.setType(resultSet.getString("notificationType"));

        return notification;
    }
}
