package com.cmr.cm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : rajith
 */
@Controller
public class HomeController {

    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String redirectHome(){
        return "home";
    }
}
