package com.Springboot.Springboot.service;

import com.Springboot.Springboot.Entity.EmployeeDTO;
import com.Springboot.Springboot.pojo.Employee;

import java.text.ParseException;
import java.util.List;


public interface EmployeeService {
    public List<Employee> getEmployees();

    public Employee getEmployee(long empID);

    public String addEmployee(Employee employee) throws ParseException, AgenotFoundException;

    public EmployeeDTO updateEmployee(EmployeeDTO employee);

    Employee findHighestsalary();
}
