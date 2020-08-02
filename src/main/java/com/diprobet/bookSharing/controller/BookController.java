package com.diprobet.bookSharing.controller;

import com.diprobet.bookSharing.dto.Review;
import com.diprobet.bookSharing.entity.Book;
import com.diprobet.bookSharing.entity.Transaction;
import com.diprobet.bookSharing.entity.User;
import com.diprobet.bookSharing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/bookList", method = RequestMethod.GET)
    public String bookList(@RequestParam(required = false) Integer userId,
                           @RequestParam(required = false) boolean excludeOwner,
                           ModelMap modelMap,
                           HttpSession session) {
        List<Book> bookList;

        if (Objects.isNull(userId)) {
            bookList = bookService.allBookList();
        } else {
            bookList = bookService.allBookList(userId, excludeOwner);
            if (excludeOwner) {
                User user = (User) session.getAttribute("currentUser");

                Map<Integer, Boolean> showRequestedByButtonMap = new HashMap<>();

                for (Book book: bookList) {
                    boolean isRequestedBy = bookService.isBookRequestedBy(book.getBookId(), user.getUserId());
                    showRequestedByButtonMap.putIfAbsent(book.getBookId(), !isRequestedBy);
                }

                modelMap.put("showRequestedByButtonMap", showRequestedByButtonMap);
            }

            modelMap.put("excludeOwner", excludeOwner);
        }

        modelMap.put("bookList", bookList);

        return "bookList";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String viewBookDetailPage(ModelMap modelMap, @RequestParam("bookId") int bookId) {

        Book book = bookService.findBook(bookId);
        modelMap.put("book", book);

        List<Transaction> listOfIndividualBookRequest = bookService.listOfIndividualBooksRequest(bookId);
        modelMap.put("listOfIndividualBookRequest", listOfIndividualBookRequest);

        List<Review>reviewList = bookService.reviewList(bookId);
        modelMap.put("ListOfReview",reviewList);

        double bookRatingDouble = bookService.findBookRating(bookId);
        int bookRating = (int) Math.floor(bookRatingDouble);
        modelMap.put("bookRating", bookRating);


        return "bookDetail";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteBook(@RequestParam("bookId") int bookId, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        bookService.deleteBook(bookId);

        if (user.isAdmin()) {
            return "redirect:http://localhost:8080/book/bookList";
        } else {
            return "redirect:http://localhost:8080/book/bookList?userId=" + user.getUserId();
        }
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String viewBookUploadPage(ModelMap modelMap) {
        Book book = new Book();

        modelMap.put("book", book);
        setupReferenceData(modelMap);

        return "bookUploadForm";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute Book book, BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) {
            setupReferenceData(modelMap);
            return "bookUploadForm";
        }

        System.out.println(book.getUploaderId());

        bookService.uploadBook(book);

        return "redirect:http://localhost:8080/book/bookList?userId=" + book.getUploaderId();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editBook(@RequestParam("bookId") int bookId, ModelMap modelMap) {

        Book book = bookService.findBook(bookId);
        setupReferenceData(modelMap);
        modelMap.put("book", book);

        return "editBook";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editBook(@ModelAttribute Book book) {
        bookService.updateBook(book);

        return "redirect:http://localhost:8080/book/detail?bookId=" + book.getBookId();
    }

    private void setupReferenceData(ModelMap modelMap) {
        modelMap.put("bookTypeOptionList", new ArrayList<>(Arrays.asList("Academic", "Biography", "Textbook", "Fantasy","Science fiction", "Thriller", "Poetry","Mythology")));
    }
}
