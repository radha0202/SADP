package com.hrapplication.assi1.service;

import com.hrapplication.assi1.model.Employee;
import com.hrapplication.assi1.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Optional<Employee> getById(Long id) {
        return repo.findById(id);
    }

    public Employee create(Employee e) {
        return repo.save(e);
    }

    public Employee update(Long id, Employee updated) {
        return repo.findById(id).map(emp -> {
            emp.setName(updated.getName());
            emp.setDepartment(updated.getDepartment());
            emp.setSalary(updated.getSalary());
            return repo.save(emp);
        }).orElse(null);
    }

    public boolean delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}


