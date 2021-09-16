package com.learning.webservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {

    @Autowired
    Environment env;

    /**
     *  This method is dummy call
     * @return
     */
    @GetMapping("/hello")
     String hello(){
       log.info("Incoming request");
       return "Hello Dhiraj request servered by port "+env.getProperty("local.server.port");
    }
    @GetMapping("/a")
    String demo(){
        log.info("Another dummy call");
        return "dummy call";
    }
}
