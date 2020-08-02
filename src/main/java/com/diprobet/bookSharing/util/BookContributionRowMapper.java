package com.diprobet.bookSharing.util;

import com.diprobet.bookSharing.dto.BookContribution;
import com.diprobet.bookSharing.entity.Book;
import com.diprobet.bookSharing.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookContributionRowMapper implements RowMapper<BookContribution> {
    @Override
    public BookContribution mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        BookContribution bookContribution = new BookContribution();

        bookContribution.getUser().setFullName(resultSet.getString("fullName"));
        bookContribution.getUser().setUserName(resultSet.getString("userName"));
        bookContribution.setBookCount(resultSet.getInt("bookCount"));

        return bookContribution;
    }
}
