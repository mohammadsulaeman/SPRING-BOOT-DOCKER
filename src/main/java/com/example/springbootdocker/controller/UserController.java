package com.example.springbootdocker.controller;

import com.example.springbootdocker.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @GetMapping("/")
    public String index(){
        LOGGER.info("Layout Home");
        return "index";
    }

    @GetMapping("/showAddUser")
    public String showAddUser(Model model){
        User user = new User();
        model.addAttribute("users",user);
        LOGGER.info("Layout New Users");
        return "new_user";
    }

    @PostMapping("/home")
    public String saveUsers(Model model,@ModelAttribute("User") User user){
        LOGGER.info("Save Users");
        User user1 = new User();
        user1.setUserId(UUID.randomUUID().toString());
        user1.setFirstName(user.getFirstName());
        user1.setMiddleName(user.getMiddleName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setPhone(user.getPhone());
        user1.setAddress(user.getAddress());
        user1.setJender(user.getJender());
        LOGGER.info(String.format("Data Save Users = %s",user1));
        model.addAttribute("users",user1);
        return "home";
    }


}
