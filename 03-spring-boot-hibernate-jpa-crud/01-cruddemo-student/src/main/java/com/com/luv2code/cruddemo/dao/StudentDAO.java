package com.com.luv2code.cruddemo.dao;

import com.com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByFirstName(String firstName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}