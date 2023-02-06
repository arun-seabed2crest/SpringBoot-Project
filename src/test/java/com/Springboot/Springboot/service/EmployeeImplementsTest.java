package com.Springboot.Springboot.service;

import com.Springboot.Springboot.Entity.EmployeeDTO;
import com.Springboot.Springboot.doa.EmployeeDao;
import com.Springboot.Springboot.pojo.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({SpringExtension.class})
class EmployeeImplementsTest {

    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeImplements employeeservice;

    List<EmployeeDTO> employeeDTOList;

    @BeforeEach
    void getEmployees(){
        employeeDTOList = new ArrayList<>();
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("seabed2crest");
        employeeDTOList.add(employeeDTO);
    }

    @Test
    void createEmployees() throws ParseException, AgenotFoundException {
        Employee employee = new Employee();
        employee.setEmpID(1);
        employee.setAge(17);
        employee.setSal(1500);
        String str=employeeservice.addEmployee(employee);
        assertEquals("successfully saved",str);
    }

   @Test
    void addEmployees(){
       Mockito.when(employeeDao.findAll()).thenReturn(employeeDTOList);
       List<Employee> employeeDTO = employeeservice.getEmployees();
       assertNotNull(employeeDTO);
   }
   @Test
    void findHighestsalary(){
        Mockito.when(employeeDao.findAll()).thenReturn(employeeDTOList);
   }
   @Test
    public void whenExceptionThrown_AssertionSucceds(){
        Employee employee = new Employee();
        employee.setEmpID(10);
        employee.setName("arun");
        employee.setAge(123);
        employee.setSal(1300);
        employee.setDate("06/02/2023");

        AgenotFoundException exception = assertThrows(AgenotFoundException.class, () -> {
            employeeservice.addEmployee(employee);
        } );
        String expectedMessage = "InvalidAge";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
   }
}