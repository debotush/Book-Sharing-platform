package com.diprobet.bookSharing.util;

import com.diprobet.bookSharing.entity.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();
        book.setUploaderId(resultSet.getInt("uploaderId"));
        book.setBookId(resultSet.getInt("bookId"));
        book.setBookName(resultSet.getString("bookName"));
        book.setBookEdition(resultSet.getString("bookEdition"));
        book.setBookPublication(resultSet.getString("bookPublication"));
        book.setBookAuthor(resultSet.getString("bookAuthor"));
        book.setBookCategory(resultSet.getString("bookCategory"));
        book.setCoverPhotoOfBookData(resultSet.getBytes("coverPhotoOfBookData"));
        book.setBookData(resultSet.getBytes("bookData"));

        return book;
    }
}
