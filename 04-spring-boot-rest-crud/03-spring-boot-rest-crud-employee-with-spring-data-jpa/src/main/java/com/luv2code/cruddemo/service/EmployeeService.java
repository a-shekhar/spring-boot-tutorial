package com.luv2code.cruddemo.service;

import com.luv2code.cruddemo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();

    Optional<Employee> findById(int id);


    Employee save(Employee employee);

    void deleteByid(int id);
}
