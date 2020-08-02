package com.diprobet.bookSharing.dao;

import com.diprobet.bookSharing.dto.BookContribution;
import com.diprobet.bookSharing.dto.Review;
import com.diprobet.bookSharing.entity.Book;
import com.diprobet.bookSharing.entity.Transaction;
import com.diprobet.bookSharing.entity.User;

import java.util.List;

public interface BookDao {
    List<Book> allBookList();

    List<Book> allBookList(int userId, boolean excludeOwner);

    void deleteBook(int bookId);

    void updateBook(Book book);

    Book findBook(int bookId);

    List<BookContribution> topSharedBooks(int howMany);

    void uploadBook(Book book);

    void requestBook(Book book, User user);

    void shareBook(int transactionId, String status);

    List<Transaction> listOfIndividualBooksRequest(int bookId);

    List<Transaction> requestedBookListOfIndividualUser(int userId);

    boolean isBookRequestedBy(int userId, int bookId);

    void insertReview(Review review);

    public List<Review> reviewList(int bookId);

    double findBookRating(int bookId);

    Transaction findTransaction(int transactionId);

    List<Book> searchBook(String param);
}
