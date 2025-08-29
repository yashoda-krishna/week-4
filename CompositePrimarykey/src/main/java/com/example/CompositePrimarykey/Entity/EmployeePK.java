package com.example.CompositePrimarykey.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Embeddable

public class EmployeePK implements Serializable {

    @Column(name="emp_id")
    private Integer empId;
    @Column(name="dept_id")
    private Integer deptId;
}
