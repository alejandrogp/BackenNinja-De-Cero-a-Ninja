package com.udemy.controller;

import com.udemy.constants.ViewConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/contacts")
public class ContactController {

    @GetMapping("/contactform")
    private String redirectContactForm(){
        return ViewConstant.CONTACT_FORM;
    }

}
