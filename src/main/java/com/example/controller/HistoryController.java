package com.example.controller;

import com.example.service.RecordServiceImpl;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class HistoryController {
    @Autowired
    private RecordServiceImpl recordService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public ModelAndView historyPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView model = new ModelAndView();
        model.addObject("user", userService.getUser(auth.getName()));
        model.addObject("records", recordService.getRecordsByUsername(auth.getName()));
        model.setViewName("history");

        return model;
    }
}
