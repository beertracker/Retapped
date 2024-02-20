package com.retapped.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retapped.domain.Beer;
import com.retapped.service.RetappedService;

@RestController
// @RequestMapping()
public class RetappedController {

    @Autowired
    private RetappedService service;

    @GetMapping("/hello")
    public String sayHello() {
        return String.format("Hello!");
    }

    @GetMapping("/grabABeer")
    public List<Beer> grabABeer() {
        return service.grabABeer();
    }
}

