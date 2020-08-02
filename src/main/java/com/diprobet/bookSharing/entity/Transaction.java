package com.diprobet.bookSharing.entity;

public class Transaction {
    private int transactionId;
    private User requestedBy;
    private User owner;
    private int bookId;
    private String status;

    private Book book;

    public Transaction() {
        super();
    }

    public Transaction(int transactionId, User requestedBy, User owner, int bookId, String status) {
        this.transactionId = transactionId;
        this.requestedBy = requestedBy;
        this.owner = owner;
        this.bookId = bookId;
        this.status = status;
    }

    public Transaction(int transactionId, User requestedBy, User owner, int bookId, String status, Book book) {
        this.transactionId = transactionId;
        this.requestedBy = requestedBy;
        this.owner = owner;
        this.bookId = bookId;
        this.status = status;
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public User getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPending() {
        return this.status.equals("Pending");
    }

    public boolean isApproved() {
        return this.status.equals("Approve");
    }
}
