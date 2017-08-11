package com.example.controller;

import com.example.service.CompanyServiceImpl;
import com.example.service.RecordServiceImpl;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class HistoryController {
    @Autowired
    private RecordServiceImpl recordService;

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyServiceImpl companyService;

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public ModelAndView historyPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView model = new ModelAndView();
        model.addObject("user", userService.getUser(auth.getName()));
        model.addObject("records", recordService.getRecordsByUsername(auth.getName()));
        model.addObject("companies", companyService.getAllCompanies());
        model.addObject("amounts", recordService.getMinMaxAmountByUsername(auth.getName()));
        model.setViewName("history");

        return model;
    }

    @RequestMapping(value = "/history/filterByCompany", method = RequestMethod.GET)
    public ModelAndView filterByCompany(@RequestParam("company") int id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView model = new ModelAndView();
        model.addObject("user", userService.getUser(auth.getName()));
        model.addObject("records", recordService.getRecordsByCompany(auth.getName(), id));
        model.addObject("companies", companyService.getAllCompanies());
        model.setViewName("history");

        return model;
    }

    @RequestMapping(value = "/history/filterByAmount", method = RequestMethod.GET)
    public ModelAndView filterByAmount(@RequestParam("amount") String amount) {
        int min = Integer.parseInt(amount.split(",")[0]);
        int max = Integer.parseInt(amount.split(",")[1]);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView model = new ModelAndView();
        model.addObject("user", userService.getUser(auth.getName()));
        model.addObject("records", recordService.getRecordsByAmount(auth.getName(), min, max));
        model.addObject("companies", companyService.getAllCompanies());
        model.setViewName("history");

        return model;
    }
}
