package com.learning.webservices.springlearning.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("users")
public class UserController {
    @GetMapping(path = "/{userId}")
    String getuser(@PathVariable String userId){
        log.info("Request recived for user "+userId);

        return "API working "+userId;


    }
}
