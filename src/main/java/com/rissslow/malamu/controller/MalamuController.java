package com.rissslow.malamu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MalamuController {

    @GetMapping("/test")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
