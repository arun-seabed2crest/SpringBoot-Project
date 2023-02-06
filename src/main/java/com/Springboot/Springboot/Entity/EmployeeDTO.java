package com.Springboot.Springboot.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="employee")
public class EmployeeDTO {

    @Id
    private long empID;

    private String name;

    private int sal;

    private int age;
    private String date;
    private String Status;


}

