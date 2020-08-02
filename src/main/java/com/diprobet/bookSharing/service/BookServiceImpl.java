package com.diprobet.bookSharing.service;

import com.diprobet.bookSharing.dao.BookDao;
import com.diprobet.bookSharing.dto.BookContribution;
import com.diprobet.bookSharing.dto.Review;
import com.diprobet.bookSharing.entity.Book;
import com.diprobet.bookSharing.entity.Transaction;
import com.diprobet.bookSharing.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> allBookList() {
        return bookDao.allBookList();
    }

    @Override
    public List<Book> allBookList(int userId, boolean excludeOwner) {
        return bookDao.allBookList(userId, excludeOwner);
    }

    @Override
    public boolean isBookRequestedBy(int userId, int bookId) {
        return bookDao.isBookRequestedBy(userId, bookId);
    }

    @Override
    public void deleteBook(int bookId) {
        bookDao.deleteBook(bookId);
    }


    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }


    @Override
    public Book findBook(int bookId) {
        return bookDao.findBook(bookId);
    }


    @Override
    public List<BookContribution> topSharedBooks(int howMany) {
        return bookDao.topSharedBooks(howMany);
    }

    @Override
    public void uploadBook(Book book) {
        bookDao.uploadBook(book);
    }

    @Override
    public void requestBook(Book book, User user) {
        bookDao.requestBook(book, user);
    }

    @Override
    public void shareBook(int transactionId, String status) {
        bookDao.shareBook(transactionId, status);
    }

    @Override
    public void delectBook(int bookid) {
        bookDao.deleteBook(bookid);
    }

    public Transaction findTransaction(int transactionId) {
        return bookDao.findTransaction(transactionId);
    }


    @Override
    public List<Transaction> listOfIndividualBooksRequest(int bookId) {
        return bookDao.listOfIndividualBooksRequest(bookId);
    }

    @Override
    public List<Transaction> requestedBookListOfIndividualUser(int userId) {
        return bookDao.requestedBookListOfIndividualUser(userId);
    }

    @Override
    public void insertReview(Review review) {
        bookDao.insertReview(review);
    }

    @Override
    public List<Review> reviewList(int bookId) {
        return bookDao.reviewList(bookId);
    }

    @Override
    public double findBookRating(int bookId) {
        return bookDao.findBookRating(bookId);
    }

    @Override
    public List<Book> searchBook(String param){
        return bookDao.searchBook(param);
    }

}
