package com.Springboot.Springboot.service;

import com.Springboot.Springboot.Entity.EmployeeDTO;
import com.Springboot.Springboot.doa.EmployeeDao;
import com.Springboot.Springboot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service

public class EmployeeImplements implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public java.util.List<Employee> getEmployees() {
        List<EmployeeDTO> employeeDTOList =  employeeDao.findAll();
        List<Employee> employeeList = new ArrayList<>();
        for (EmployeeDTO employeeDTO : employeeDTOList) {
            Employee employee = new Employee();
            employee.setAge(employeeDTO.getAge());
            employee.setName(employeeDTO.getName());
            employee.setSal(employeeDTO.getSal());
            employee.setEmpID(employeeDTO.getEmpID());
            employee.setDate(employeeDTO.getDate());
            employee.setStatus(employeeDTO.getStatus());
            employeeList.add(employee);
        }
        return employeeList;
    }
    @Override
    public Employee getEmployee(long empID) {
        EmployeeDTO employeeDTO = employeeDao.getReferenceById(empID);
        Employee employee = new Employee();
        employee.setAge(employeeDTO.getAge());
        return employee;
    }
    @Override
    public String addEmployee(Employee employee) throws ParseException, AgenotFoundException {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmpID(employee.getEmpID());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSal(employee.getSal());
        //Date date1 = new SimpleDateFormat("dd/mm/yyyy").parse(employee.getDate());
        //employeeDTO.setDate(String.valueOf(date1));
        employeeDTO.setDate(employee.getDate());
        int age= employeeDTO.getAge();
        employeeDTO.setAge(employee.getAge());
        if(age>1 && age<18){
            employeeDTO.setStatus("Minor");
        }
        else if(age>18 && age<60){
            employeeDTO.setStatus("Major");
        }
        else if (age>60 && age<100){
            employeeDTO.setStatus("Senior Citizen");
        }
        try{
            if (age<1 || age>100){
                throw new AgenotFoundException("InvalidAge");
            }
        } catch (Exception e) {
            System.out.println("AgenotFoundException"+e);
        }
        employeeDao.save(employeeDTO);
        return "successfully saved";
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employee) {
        employeeDao.save(employee);
        return employee;
    }

    @Override
    public Employee findHighestsalary() {
    List<EmployeeDTO> list = employeeDao.findAll();
        Collections.sort(list, new Comparator<EmployeeDTO>() {
            @Override
            public int compare(EmployeeDTO o1, EmployeeDTO o2) {
                return (int) (o2.getSal()- o1.getSal());
            }
        });
        EmployeeDTO employeeDTO = list.get(0);
        Employee employee = new Employee();
        employee.setSal(employeeDTO.getSal());
        employee.setName(employeeDTO.getName());
        employee.setEmpID(employeeDTO.getEmpID());
        return employee;
    }

    public Date getDate(Employee employee) { return getDate(employee); }


}