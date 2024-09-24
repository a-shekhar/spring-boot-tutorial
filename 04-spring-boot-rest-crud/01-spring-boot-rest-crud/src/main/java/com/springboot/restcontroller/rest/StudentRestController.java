package com.springboot.restcontroller.rest;

import com.springboot.restcontroller.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> theStudents;

    // define the @PostConstruct to load the student data.. only once
    @PostConstruct
    public void loadData(){
        theStudents  = new ArrayList<>();
        theStudents.add(new Student("Aditya", "Raj"));
        theStudents.add(new Student("Narendra", "Modi"));
        theStudents.add(new Student("Yogi", "Ji"));
    }

    // define endpoint for "/students"
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    // define endpoint for "/students/{studentId}" return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // check the studentId again list size
        if((studentId >= theStudents.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }


}
