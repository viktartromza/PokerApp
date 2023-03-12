package com.tms.controller;

import com.tms.domain.User;
import com.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller // указываем, что контроллер в MVC
@RequestMapping("/user") // указываем, на какой url откликается в HandlerMappinge
public class UserController {

    UserService userService;

   @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping ("/{id}")// указываем на какой метод откликается в HandlerMappinge и /доп для значения @PathVariable
    public String getUserById(@PathVariable int id, Model model) {
        //    log.info("doing/user Get method!");
       User user = UserService.getUserById(id);
      model.addAttribute("user", user);
        return "singleUser";



    }
}