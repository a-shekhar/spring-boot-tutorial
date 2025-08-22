package com.anjori.cruddemo.service;

import java.util.List;

import com.anjori.cruddemo.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
