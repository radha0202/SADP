package com.example.employeeservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eno;

    @NotBlank(message = "Employee name is mandatory")
    private String ename;

    @NotBlank(message = "Designation is mandatory")
    private String designation;

    @NotBlank(message = "Department is mandatory")
    private String deptName;

    @Min(value = 0, message = "Salary must be non-negative")
    private double salary;

    public Employee() {}

    public Employee(String ename, String designation, String deptName, double salary) {
        this.ename = ename;
        this.designation = designation;
        this.deptName = deptName;
        this.salary = salary;
    }

    public Long getEno() { return eno; }
    public void setEno(Long eno) { this.eno = eno; }

    public String getEname() { return ename; }
    public void setEname(String ename) { this.ename = ename; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
