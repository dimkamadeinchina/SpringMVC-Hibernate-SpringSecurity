package com.example.controller;

import com.example.model.Company;
import com.example.model.Record;
import com.example.model.User;
import com.example.service.CompanyServiceImpl;
import com.example.service.RecordServiceImpl;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping(value = "/user")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;

    @Autowired
    private RecordServiceImpl recordService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "company", method = RequestMethod.GET)
    public ModelAndView CompanyPage(@RequestParam("id") int id) {
        ModelAndView model = new ModelAndView();
        model.addObject("company", companyService.getCompanyById(id));
        model.addObject("messageID", id);
        model.setViewName("company");
        return model;
    }

    @RequestMapping(value = "createRecord", method = RequestMethod.POST)
    public ModelAndView createRecord(@ModelAttribute Record record, int id_company){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User user = userService.getUser(auth.getName());
        user.setBalance(user.getBalance() - record.getAmount());
        userService.updateUser(user);

        record.setId_company(id_company);
        record.setUsername(auth.getName());
        record.setDate(new Date());
        recordService.createRecord(record);
        return new ModelAndView("redirect:/user");
    }
}
