package com.example.controller;

import com.example.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;

    @RequestMapping(value = "/user/company", method = RequestMethod.GET)
    public ModelAndView CompanyPage(@RequestParam("id") int id) {
        ModelAndView model = new ModelAndView();
        model.addObject("company", companyService.getCompanyById(id));
        model.addObject("messageID", id);
        model.setViewName("company");
        return model;
    }
}
