package com.Springboot.Springboot.pojo;

import com.Springboot.Springboot.Entity.EmployeeDTO;
import lombok.Data;

@Data
public class Employee {
    private long empID;
    private String name;
    private int sal;
    private int age;
    private String date;
    private String Status;


}
