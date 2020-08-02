package com.diprobet.bookSharing.controller;

import com.diprobet.bookSharing.dto.BookContribution;
import com.diprobet.bookSharing.service.BookService;
import com.diprobet.bookSharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/report")
public class ReportController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String reportPage(ModelMap modelMap) {
        return "reportPage";
    }

    @RequestMapping(value = "/topUsers", method = RequestMethod.GET)
    public String topContributors(ModelMap modelMap) {
        List<BookContribution> topContributor = userService.topContributor(3);
        modelMap.put("topContributor", topContributor);

        return "contributionPage";
    }

    @RequestMapping(value = "/topSharedBooks", method = RequestMethod.GET)
    public String topSharedBooks(ModelMap modelMap) {
        List<BookContribution> topSharedBookList = bookService.topSharedBooks(3);

        modelMap.put("bookContributionList", topSharedBookList);

        return "topSharedBooksPage";
    }


}
