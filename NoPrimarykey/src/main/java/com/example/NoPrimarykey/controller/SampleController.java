package com.example.NoPrimarykey.controller;

import com.example.NoPrimarykey.Entity.Employee;
import com.example.NoPrimarykey.Repository.EmployeeRepository;
import com.example.NoPrimarykey.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@RestController
public class SampleController {

    @Autowired
    private JdbcClient jdbcClient;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public  List<EmployeeDto> demo(){
        Instant start = Instant.now();
        List<EmployeeDto> employeeDtos = jdbcClient.sql("select * from employee_table").query(EmployeeDto.class).list();
        employeeDtos.forEach(x -> System.out.println(x));

        Instant end=Instant.now();
        long millis = Duration.between(start, end).toMillis();
        System.out.println("rtt "+millis);
        return employeeDtos;
    }
    @GetMapping("/r")
    public String demo1(){
        Instant start = Instant.now();
        List<Employee> employees1 = employeeRepository.findAll();
        employees1.forEach(x -> System.out.println(x));
        Instant end=Instant.now();
        long millis = Duration.between(start, end).toMillis();
        System.out.println("rtt "+millis);
        return "";
    }
}
