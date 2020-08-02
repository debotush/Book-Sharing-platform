package com.diprobet.bookSharing.util;


import com.diprobet.bookSharing.dto.BookContribution;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TopSharedBookRowMapper implements RowMapper<BookContribution> {


    @Override
    public BookContribution mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        BookContribution bookContribution = new BookContribution();

        bookContribution.getBook().setBookName(resultSet.getString("bookName"));
        bookContribution.getBook().setBookEdition(resultSet.getString("edition"));
        bookContribution.getBook().setBookPublication(resultSet.getString("publication"));
        bookContribution.getBook().setBookAuthor(resultSet.getString("author"));
        bookContribution.getUser().setFullName(resultSet.getString("fullName"));
        bookContribution.setSharedCount(resultSet.getInt("sharedCount"));

        return bookContribution;
    }
}
