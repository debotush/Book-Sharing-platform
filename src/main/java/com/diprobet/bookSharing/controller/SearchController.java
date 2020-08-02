package com.diprobet.bookSharing.controller;

import com.diprobet.bookSharing.entity.Book;
import com.diprobet.bookSharing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Book> searchBook(@RequestParam("param") String param){

        List<Book>searchList =  bookService.searchBook(param);

        return searchList;
    }

}
