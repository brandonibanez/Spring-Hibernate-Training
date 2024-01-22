package com.luv2code.RestDemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class DemoRestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }
}
