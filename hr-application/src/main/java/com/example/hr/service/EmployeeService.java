package com.example.hr.service;

import com.example.hr.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee);
    List<Employee> getAll();
    Employee getById(Long id);
    Employee update(Long id, Employee employee);
    void delete(Long id);
}
