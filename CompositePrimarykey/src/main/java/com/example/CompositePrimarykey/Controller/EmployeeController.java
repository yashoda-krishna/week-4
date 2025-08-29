package com.example.CompositePrimarykey.Controller;

import com.example.CompositePrimarykey.Entity.Employee;
import com.example.CompositePrimarykey.Entity.EmployeePK;
import com.example.CompositePrimarykey.Service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        // Set the EmbeddedId using values from request JSON
        if (employee.getEmployeePK() == null) {
            throw new RuntimeException("EmployeePK must not be null!");
        }
        return ResponseEntity.ok(employeeService.create(employee));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }


    @GetMapping("/{empId}/{deptId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int empId, @PathVariable int deptId) {
        return ResponseEntity.ok(employeeService.findById(empId, deptId));
    }

    // UPDATE
    @PutMapping("/{empId}/{deptId}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable int empId,
            @PathVariable int deptId,
            @RequestBody Employee payload) {
        return ResponseEntity.ok(employeeService.update(empId, deptId, payload));
    }


    @DeleteMapping("/{empId}/{deptId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int empId, @PathVariable int deptId) {
        employeeService.delete(empId, deptId);
        return ResponseEntity.noContent().build();
    }
}
