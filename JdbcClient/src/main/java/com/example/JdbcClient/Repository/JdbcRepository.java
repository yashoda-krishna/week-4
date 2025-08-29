package com.example.JdbcClient.Repository;

import com.example.JdbcClient.Model.Employee;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcRepository {
    private final JdbcClient jdbcClient;
    public JdbcRepository(JdbcClient jdbcClient)
    {
        this.jdbcClient=jdbcClient;
    }
    public List<Employee> findAll()
    {
        return jdbcClient.sql("select * from employee_table")
                .query(Employee.class)
                .list();
    }
    public Optional<Employee> findBy(int empId)
    {
        return jdbcClient.sql("select * from employee_table where empId=:empId")
                .param("empid",empId)
                .query(Employee.class)

                .optional();
    }

}
