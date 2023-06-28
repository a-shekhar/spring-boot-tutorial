package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> students;
    // define @PostConstruct to load student data... ONLY ONCE
    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Aditya", "Raj"));
        students.add(new Student("Jyotsna", "Raj"));
        students.add(new Student("Anu", "Raj"));
        students.add(new Student("Aryan", "Raj"));
    }


    // define endpoint for "/students"
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    // define endpoint "/students/{studentId}" - return studnet at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // just index access

        // check the student against list size
        if (studentId >= students.size() || studentId < 0){
            throw new StudentNotFoundException("Student  id not found -> " + studentId);
        }

        return students.get(studentId);
    }




}
