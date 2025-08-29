package com.example.JdbcClient.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int empId;
    private int  deptId;
    private String name;
    private String email;


}
