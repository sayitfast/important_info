package com.sayitfast.important_info.controllers;

import com.sayitfast.important_info.models.App_User;
import com.sayitfast.important_info.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getCountries() {
        return "User";
    }


    //Modified method to Add a new user User
    @PostMapping(value = "users/addNew")
    public RedirectView addNew(App_User appUser, RedirectAttributes redir) {

        userService.save(appUser);

        RedirectView redirectView = new RedirectView("/login", true);

        redir.addFlashAttribute("message", "You successfully registered! You can now login");

        return redirectView;
    }

}
