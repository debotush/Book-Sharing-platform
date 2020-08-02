package com.diprobet.bookSharing.dto;

import com.diprobet.bookSharing.entity.Book;
import com.diprobet.bookSharing.entity.User;

public class BookContribution {

    private User user;
    private Book book;
    private int bookCount;
    private int sharedCount;

    public BookContribution(User user, int bookCount) {
        this.user = user;
        this.bookCount = bookCount;
    }



    public BookContribution(Book book, int sharedCount) {
        this.book = book;
        this.sharedCount = sharedCount;
    }

    public BookContribution() {
        this.user = new User();
        this.book = new Book();
    }



    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public int getSharedCount() {
        return sharedCount;
    }

    public void setSharedCount(int sharedCount) {
        this.sharedCount = sharedCount;
    }
}
