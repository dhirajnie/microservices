package com.learning.sociallogin.sociallogin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {
    @GetMapping("/home")
    public String displayHomePage(Model model, @AuthenticationPrincipal OAuth2User principal) {

        if (principal != null) {
            String name = principal.getAttribute("name");
            log.info(name + " Has logged in the system");
            model.addAttribute("name",name);
        }
        return "home";
    }
}
