package com.example.JdbcClient.Controller;

import com.example.JdbcClient.Model.Employee;
import com.example.JdbcClient.Repository.JdbcRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class JdbcController {
    private  final JdbcRepository jdbcRepository;
    public JdbcController(JdbcRepository jdbcRepository)
    {
        this.jdbcRepository=jdbcRepository;
    }
    @GetMapping
    public List<Employee> getAllEmployees()

    {
        return jdbcRepository.findAll();
    }
}
