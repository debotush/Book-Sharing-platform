package com.diprobet.bookSharing.dto;

import com.diprobet.bookSharing.entity.User;

import java.io.Serializable;

public class Review implements Serializable {

    private int reviewId;
    private int reviewedById;
    private int bookId;
    private String review;
    private int rating;
    private User user;


    public Review(int reviewId, int reviewedById, int bookId, String review, int rating) {
        this.reviewId = reviewId;
        this.reviewedById = reviewedById;
        this.bookId = bookId;
        this.review = review;
        this.rating = rating;
    }

/*    public Review(String bookRating){
        this.bookRating = bookRating;
    }  */

    public Review(User user) {
        this.user = user;
    }

    public Review() {
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getReviewedById() {
        return reviewedById;
    }

    public void setReviewedById(int reviewedById) {
        this.reviewedById = reviewedById;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
