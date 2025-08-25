package com.example.CompositePrimarykey.Controller;

import com.example.CompositePrimarykey.Entity.Employee;
import com.example.CompositePrimarykey.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;
    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return repository.save(employee);

    }
    @GetMapping
    public List<Employee> getAll()
    {
        return repository.findAll();

    }


}
