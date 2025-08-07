package com.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

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

    // need a controller method to read form data
    // and add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
        //  read the request parameter from the form
        String name = request.getParameter("studentName");
        // convert to uppercase
        String result = "Hey, " + name.toUpperCase() + "!";
        //  display the name in the view  (helloWorld.html)
        //  model is a container for data that will be passed to the view
        //  we use the addAttribute method to add data to the model
        //  the key is "message", the value is the uppercase name we got from the form
        //  the key-value pair will be added to the model that will be available in the view (helloWorld.html)
        //  add the data to the model
        model.addAttribute("message", result);
        //  forward the request to the helloWorld.html page
        return "helloWorld";
    }

    // need a controller method to read form data
    // and add data to the model
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName")
                                              String name, Model model){
        // convert to uppercase
        String result = "Hey My friend from V3, " + name.toUpperCase() + "!";
        //  display the name in the view  (helloWorld.html)
        //  model is a container for data that will be passed to the view
        //  we use the addAttribute method to add data to the model
        //  the key is "message", the value is the uppercase name we got from the form
        //  the key-value pair will be added to the model that will be available in the view (helloWorld.html)
        //  add the data to the model
        model.addAttribute("message", result);
        //  forward the request to the helloWorld.html page
        return "helloWorld";
    }
}
