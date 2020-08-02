package com.diprobet.bookSharing.util;

import com.diprobet.bookSharing.entity.User;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;


import java.sql.ResultSet;
import java.sql.SQLException;

public class UserUtil {

    public SqlParameterSource getSqlParambyModel(User u) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        if(u != null) {
            parameterSource.addValue("userId", u.getUserId());
            parameterSource.addValue("fullName", u.getFullName());
            parameterSource.addValue("userName", u.getUserName());
            parameterSource.addValue("userPassword", u.getUserPassword());
            parameterSource.addValue("userMail", u.getUserMail());
            parameterSource.addValue("userContact", u.getUserContact());
            parameterSource.addValue("userType", u.getUserType());
        }

        return parameterSource;

    }
}
