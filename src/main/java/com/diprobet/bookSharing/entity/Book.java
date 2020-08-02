package com.diprobet.bookSharing.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class Book implements Serializable {

    private int bookId;

    @JsonIgnore
    private int uploaderId;

    private String bookName;

    @JsonIgnore
    private String bookEdition;

    @JsonIgnore
    private String bookPublication;

    @JsonIgnore
    private String bookAuthor;

    @JsonIgnore
    private String bookCategory;

    @JsonIgnore
    private byte[] coverPhotoOfBookData;

    @JsonIgnore
    private byte[] bookData;

    @JsonIgnore
    private MultipartFile uploadedCoverPhotoOfBook;

    @JsonIgnore
    private MultipartFile uploadedBook;

    public Book() {
    }

    public Book(int uploaderId, String bookName, String bookEdition, String bookPublication,
                String bookAuthor, String bookCategory, byte[] coverPhotoOfBookData, byte[] bookData) {
        super();
        this.uploaderId = uploaderId;
        this.bookName = bookName;
        this.bookEdition = bookEdition;
        this.bookPublication = bookPublication;
        this.bookAuthor = bookAuthor;
        this.bookCategory = bookCategory;
        this.coverPhotoOfBookData = coverPhotoOfBookData;
        this.bookData = bookData;
    }

    public int getBookId() {
        return this.bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(int uploaderId) {
        this.uploaderId = uploaderId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(String bookEdition) {
        this.bookEdition = bookEdition;
    }

    public String getBookPublication() {
        return bookPublication;
    }

    public void setBookPublication(String bookPublication) {
        this.bookPublication = bookPublication;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public byte[] getCoverPhotoOfBookData() {
        return coverPhotoOfBookData;
    }

    public void setCoverPhotoOfBookData(byte[] coverPhotoOfBookData) {
        this.coverPhotoOfBookData = coverPhotoOfBookData;
    }

    public byte[] getBookData() {
        return bookData;
    }

    public void setBookData(byte[] bookData) {
        this.bookData = bookData;
    }

    public MultipartFile getUploadedCoverPhotoOfBook() {
        return uploadedCoverPhotoOfBook;
    }

    public void setUploadedCoverPhotoOfBook(MultipartFile uploadedCoverPhotoOfBook) {
        this.uploadedCoverPhotoOfBook = uploadedCoverPhotoOfBook;
    }

    public MultipartFile getUploadedBook() {
        return uploadedBook;
    }

    public void setUploadedBook(MultipartFile uploadedBook) {
        this.uploadedBook = uploadedBook;
    }
}
