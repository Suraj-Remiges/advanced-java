package com.remiges.adv_java_assignment.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remiges.adv_java_assignment.entity.Employee;
import com.remiges.adv_java_assignment.repo.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    // Filed inject
    private EmployeeRepository employeeRepository;

    @SuppressWarnings("null")
    // method to save employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Method to get all employee's id and full name
    public java.util.List<Object[]> employeeList() {
        return employeeRepository.findAll().stream()
                .map(employee -> new Object[] { employee.getId(), employee.getFullName() })
                .collect(Collectors.toList());

    }

    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeRepository.findById(id);

    }

}
