package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processModel() {
        return "helloworld";
    }

    @RequestMapping("/processFormV2")
    public String processModelV2(HttpServletRequest request,
                                 Model model) {
        String name = request.getParameter("studentName");
        model.addAttribute("message", "Yo! " +
                name);
        return "helloworld";
    }

    @GetMapping("/processFormV3")
    public String processModelV3(@RequestParam("studentName") String name,
                                 Model model) {
        model.addAttribute("message", "YoYo! " +
                name);
        return "helloworld";
    }
}
