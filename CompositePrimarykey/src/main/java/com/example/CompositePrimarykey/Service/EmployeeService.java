package com.example.CompositePrimarykey.Service;

import com.example.CompositePrimarykey.Entity.Employee;
import com.example.CompositePrimarykey.Entity.EmployeePK;
import com.example.CompositePrimarykey.Exception.NotFoundException;
import com.example.CompositePrimarykey.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // CREATE employee
    public Employee create(Employee employee) {
        System.out.println("employee : "+employee);
        EmployeePK employeePK=new EmployeePK();
        employeePK.setEmpId(employee.getEmployeePK().getEmpId());
        employeePK.setDeptId(employee.getEmployeePK().getDeptId());
        employee.setEmployeePK(employeePK);

        return employeeRepository.save(employee);
    }

    // GET ALL employees
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    // GET employee by ID
    public Employee findById(int empId, int deptId) {
        EmployeePK id = new EmployeePK();
        id.setDeptId(deptId);
        id.setEmpId(empId);
        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Employee not found: empId=" + empId + ", deptId=" + deptId));
    }

    // UPDATE employee
    public Employee update(int empId, int deptId, Employee payload) {
        Employee existing = findById(empId, deptId);
        existing.setName(payload.getName());
        existing.setSalary(payload.getSalary());
        existing.setEmail(payload.getEmail());
        return employeeRepository.save(existing);
    }

    // DELETE employee
    public void delete(int empId,int deptId) {
        EmployeePK id = new EmployeePK();
        id.setEmpId(empId);
        id.setDeptId(deptId);
        if (!employeeRepository.existsById(id)) {
            throw new NotFoundException("Employee not found: empId=" + empId + ", deptId=" + deptId);
        }
        employeeRepository.deleteById(id);
    }
}
