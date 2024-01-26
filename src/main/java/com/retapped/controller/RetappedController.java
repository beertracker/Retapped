package com.retapped.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetappedController {

    @GetMapping("/hello")
    public String sayHello() {
        return String.format("Hello!");
    }
}

