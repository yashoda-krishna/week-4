package com.example.CompositePrimarykey.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@IdClass(EmployeePK.class)
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
