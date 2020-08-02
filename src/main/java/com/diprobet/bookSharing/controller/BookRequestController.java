package com.diprobet.bookSharing.controller;


import com.diprobet.bookSharing.dto.Notification;
import com.diprobet.bookSharing.entity.Book;
import com.diprobet.bookSharing.entity.User;
import com.diprobet.bookSharing.service.BookService;
import com.diprobet.bookSharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("request")
public class BookRequestController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String requestForBook(@RequestParam("bookId") int bookId, HttpSession session){
        User user = (User)session.getAttribute("currentUser");
        Book book = bookService.findBook(bookId);
        bookService.requestBook(book,user);
        sendNotification(user, book);

        return "redirect:http://localhost:8080/book/bookList?userId=" + user.getUserId() + "&excludeOwner=true";
    }

    private void sendNotification(User user, Book book) {
        String message = user.getFullName() + " requested  for " + book.getBookName();
        User notifiedTo = userService.findUser(book.getUploaderId());
        Notification notification = new Notification(notifiedTo, book, "Request", message);
        userService.sendNotification(notification);
    }

}
