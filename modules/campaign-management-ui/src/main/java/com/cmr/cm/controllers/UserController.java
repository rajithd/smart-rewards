package com.cmr.cm.controllers;

import com.cmr.beans.user.UserAccount;
import com.cmr.cm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : rajith
 */
@Controller
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/create-user")
    public String redirectCreateUser(){
        return "create-user";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create-user")
    public String submitCreateUser(UserAccount userAccount){
        userService.saveUser(userAccount);
        return "redirect:/home";
    }

}
