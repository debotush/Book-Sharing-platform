package com.diprobet.bookSharing.util;

import com.diprobet.bookSharing.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRawMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setUserId(resultSet.getInt("userId"));
        user.setFullName(resultSet.getString("fullName"));
        user.setUserName(resultSet.getString("userName"));
        user.setUserPassword(resultSet.getString("userPassword"));
        user.setUserMail(resultSet.getString("userMail"));
        user.setUserContact(resultSet.getString("userContact"));
        user.setUserType(resultSet.getString("userType"));

        return user;
    }
}
