package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.entity.Employee;
import com.luv2code.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    public EmployeeService employeeService;


    public  EmployeeRestController(EmployeeService service){
        this.employeeService = service;
    }

    // expose "employee" and return a list of employee
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Optional<Employee> employee = employeeService.findById(employeeId);
       if(employee.isEmpty()) {
            throw new RuntimeException("Did not find employww id -> " + employeeId);
        }
        return employee.get();
    }

     // add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        // set id to 0, so merge can create insert
        employee.setId(0);
        Employee createdEmployee = employeeService.save(employee);
        return createdEmployee;
    }

    // Put /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee createdEmployee = employeeService.save(employee);
        return createdEmployee;
    }

    // Delete /employees/{employeeId} - delete existing employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Optional<Employee> deletedEmployee = employeeService.findById(employeeId);

        if (deletedEmployee.isEmpty()){
            throw new RuntimeException("Did not find employee id -> " + employeeId);
        }
        employeeService.deleteByid(employeeId);
        return "Deleted Employee " + employeeId;
    }
}
