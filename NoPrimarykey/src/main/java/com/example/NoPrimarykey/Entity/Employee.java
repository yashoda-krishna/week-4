package com.example.NoPrimarykey.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Entity
@Table(name="Employee_Table")
public class Employee {
    @Id
    @Column(name = "empId")
    private int employeeId;
    @Column(name = "deptId")
    private int deptId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
}

/*

d 
s 
1
r


*/
