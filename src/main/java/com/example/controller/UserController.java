package com.example.controller;

import com.example.service.CompanyServiceImpl;
import com.example.service.RecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private CompanyServiceImpl companyService;

    @Autowired
    private RecordServiceImpl recordService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcomePage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("index");

        return model;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("message", "This page is accessible for Admin role !");
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView userPage() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        model.addObject("user", auth.getName());
        model.addObject("companies", companyService.getAllCompanies());
        model.addObject("records", recordService.getRecordsByUsername(auth.getName()));
        model.setViewName("user");

        return model;

    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDeniedPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("message", "You are not authorized to view this page. you are chert");
        model.setViewName("accessDenied");

        return model;

    }
}
