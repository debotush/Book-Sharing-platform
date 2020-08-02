package com.diprobet.bookSharing.dto;

import com.diprobet.bookSharing.entity.Book;
import com.diprobet.bookSharing.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Notification {

    private int notificationId;

    @JsonIgnore
    private Book book;

    @JsonIgnore
    private User notificationTo;

    private String message;

    @JsonIgnore
    private boolean acknowledgement;

    private String type;

    public Notification() {
        this.book = new Book();
        this.notificationTo = new User();
    }

    public Notification(User user, Book book, String type, String message) {
        this.notificationTo = user;
        this.book = book;
        this.type = type;
        this.message = message;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public Book getBook() {
        return book;
    }

    public int getBookId() {
        return this.getBook().getBookId();
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getNotificationTo() {
        return notificationTo;
    }

    public void setNotificationTo(User notificationTo) {
        this.notificationTo = notificationTo;
    }

    public boolean isAcknowledgement() {
        return acknowledgement;
    }

    public void setAcknowledgement(boolean acknowledgement) {
        this.acknowledgement = acknowledgement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
