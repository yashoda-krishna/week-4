package com.example.CompositePrimarykey.Repository;

import com.example.CompositePrimarykey.Entity.Employee;
import com.example.CompositePrimarykey.Entity.EmployeePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, EmployeePK> {

}
