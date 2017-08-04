package com.example.controller;

import com.example.model.Role;
import com.example.model.User;
import com.example.service.RoleServiceImpl;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleServiceImpl roleService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationPage() {
        return "registration";
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public ModelAndView checkUser(String phone){
        ModelAndView model = new ModelAndView();

        if (userService.getUser(phone) != null){
            model.addObject("error", "takoi chert yzhe zdes");
            model.setViewName("registration");
            return model;
        }

        String pas = "123456";

        Role role = roleService.getRole(1);
        Set<Role> roleses = new HashSet<>();
        roleses.add(role);

        User user = new User(phone, pas,
                100,
                0,
                true,
                false,
                null,
                roleses);
        userService.saveUser(user);

        model.addObject("username", phone);
        model.addObject("password", pas);
        model.setViewName("registration");
        return model;
    }
}
