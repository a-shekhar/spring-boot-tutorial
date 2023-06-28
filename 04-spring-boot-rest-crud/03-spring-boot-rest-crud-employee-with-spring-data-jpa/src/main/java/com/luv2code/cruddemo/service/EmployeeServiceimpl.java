package com.luv2code.cruddemo.service;

import com.luv2code.cruddemo.dao.EmployeeRepository;
import com.luv2code.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceimpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    // constructor injection
    @Autowired
    public EmployeeServiceimpl(EmployeeRepository employeeDAO){
        this.employeeRepository = employeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        /*Employee theEmployee = null;
        if (result.isPresent()){
            theEmployee = result.get();
        }else{
            throw new RuntimeException("Did not find employww id -> " + id);
        }*/
        return result;
    }


    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public void deleteByid(int id) {
        employeeRepository.deleteById(id);
    }
}
