package com.example.CompositePrimarykey.Entity;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Setter
@Getter
@Entity
@Table(name="employees")
public class Employee {
//    @Id
//    private  int employeeId;
//    @Id
//    private int deptId;
    @EmbeddedId
    private EmployeePK employeePK;
    private  String name;
    private int salary;
    private String email;
}
