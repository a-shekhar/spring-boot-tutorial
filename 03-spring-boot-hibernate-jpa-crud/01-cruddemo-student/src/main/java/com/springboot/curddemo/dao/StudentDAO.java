package com.springboot.curddemo.dao;

import com.springboot.curddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();
}
