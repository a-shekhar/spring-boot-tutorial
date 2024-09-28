package com.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
    // new method to show initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloWorld-form";
    }

    // new method to process the form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloWorld";
    }
}
