package com.udemy.controller;

import com.udemy.constants.ViewConstant;
import com.udemy.model.UserCredential;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static final Log LOG = LogFactory.getLog(LoginController.class);


    @GetMapping("/")
    public String redirectToLogin(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model,
            @RequestParam(name="error", required = false) String error,
            @RequestParam(name="logout", required = false) String logout){

        LOG.info("Error: " + error);
        LOG.info("Logout: " + logout);

        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        model.addAttribute("userCredentials", new UserCredential());
        return ViewConstant.LOGIN;
    }

    @PostMapping("/loginCheck")
    public String loginCheck(@ModelAttribute(name="userCredentials")UserCredential userCredential){

        LOG.info("User credential: " + userCredential.toString());

        if(userCredential.getUserName().equals("user") &&
                userCredential.getPassword().equals("user")){
            return ViewConstant.CONTACTS;
        }

        return "redirect:/login?error";
    }

}
