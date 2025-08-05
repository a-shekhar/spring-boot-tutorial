package com.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.thymeleafdemo.model.Student;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    // method to show form for adding new student
    public String showForm(Model theModel) {

        // create a student object
        Student theStudent = new Student();

        // add the student object to the model
        theModel.addAttribute("student", theStudent);

        //  add the list of countries to the model
        theModel.addAttribute("countries", countries);

        //  add the list of languages to the model
        theModel.addAttribute("languages", languages);

        //  add the list of systems to the model
        theModel.addAttribute("systems", systems);

        // return the view name

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent){
        // log the input data
        System.out.println("theStudent: " + theStudent.getFirstName()
                                        + " " + theStudent.getLastName());
        return "student-confirmation";
    }


}
