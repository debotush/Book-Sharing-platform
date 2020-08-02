package com.diprobet.bookSharing.controller;


import com.diprobet.bookSharing.entity.Book;
import com.diprobet.bookSharing.dto.Review;
import com.diprobet.bookSharing.entity.User;
import com.diprobet.bookSharing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class ReviewController {

    @Autowired
    private BookService bookService;

    private Book book;

    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public String reviewPage(@RequestParam("bookId") int bookId, ModelMap modelMap){
        this.book = bookService.findBook(bookId);
        Review review = new Review();

        double bookRatingDouble = bookService.findBookRating(bookId);
        int bookRating = (int) Math.floor(bookRatingDouble);

        modelMap.put("bookRating", bookRating);
        modelMap.put("review",review);
        modelMap.put("book",book);



        setUpReferenceData(modelMap);

        List<Review>reviewList = bookService.reviewList(bookId);
        modelMap.put("ListOfReview",reviewList);

        return "bookReviewPage";
    }

    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public String saveReview(@ModelAttribute Review review, HttpSession session){
        bookService.insertReview(review);

        return "redirect:http://localhost:8080/review?bookId=" + book.getBookId();
    }


    private void setUpReferenceData(ModelMap modelMap) {
        Map<Integer, String> ratingOptionMap = new LinkedHashMap<>();

        ratingOptionMap.put(5, "5 Star");
        ratingOptionMap.put(4, "4 Star");
        ratingOptionMap.put(3, "3 Star");
        ratingOptionMap.put(2, "2 Star");
        ratingOptionMap.put(1, "1 Star");

        modelMap.put("ratingOptionMap", ratingOptionMap);
    }

}
