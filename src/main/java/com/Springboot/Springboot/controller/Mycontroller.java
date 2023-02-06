package com.Springboot.Springboot.controller;

import com.Springboot.Springboot.pojo.Employee;
import com.Springboot.Springboot.service.AgenotFoundException;
import com.Springboot.Springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class Mycontroller {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp")
    public List<Employee>getEmployees() { return this.employeeService.getEmployees();
    }

    @GetMapping("/emp/{empID}")
    public Employee getEmployee(long empID) { return this.employeeService.getEmployee(empID); }

    @PostMapping("/createEmployee")
    public String addEmployee(Employee employee) throws ParseException, AgenotFoundException {
        return this.employeeService.addEmployee(employee);
    }



}
