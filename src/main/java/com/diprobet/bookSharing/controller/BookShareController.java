package com.diprobet.bookSharing.controller;


import com.diprobet.bookSharing.dto.Notification;
import com.diprobet.bookSharing.entity.Book;
import com.diprobet.bookSharing.entity.Transaction;
import com.diprobet.bookSharing.entity.User;
import com.diprobet.bookSharing.service.BookService;
import com.diprobet.bookSharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "share")
public class BookShareController {
    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String requestForBook(@RequestParam("transactionId") int transactionId,
                                 @RequestParam("status") String status,
                                 @RequestParam("bookId") int bookId,
                                 HttpSession session) {

        User currentUser = (User) session.getAttribute("currentUser");


        bookService.shareBook(transactionId, status);

        sendNotification(transactionId, bookId, currentUser);

        return "redirect:http://localhost:8080/book/detail?bookId=" + bookId;
    }

    private void sendNotification(int transactionId, int bookId, User currentUser) {
        Book book = bookService.findBook(bookId);
        Transaction transaction = bookService.findTransaction(transactionId);
        User notifiedTo = transaction.getRequestedBy();
        String message = currentUser.getFullName() + " approved your request for " + book.getBookName();
        Notification notification = new Notification(notifiedTo, book, "Approve", message);
        userService.sendNotification(notification);
    }
}
