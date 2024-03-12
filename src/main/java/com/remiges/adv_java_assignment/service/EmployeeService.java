package com.remiges.adv_java_assignment.service;

import java.sql.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remiges.adv_java_assignment.entity.Departments;
import com.remiges.adv_java_assignment.entity.Employee;
import com.remiges.adv_java_assignment.entity.EmployeeShadow;
import com.remiges.adv_java_assignment.entity.Ranks;
import com.remiges.adv_java_assignment.repo.DeptRepo;
import com.remiges.adv_java_assignment.repo.EmployeeRepository;
import com.remiges.adv_java_assignment.repo.EmployeeShadowRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeShadowRepository employeeShadowRepository;

    @Autowired
    private DeptRepo deptRepo;

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

    @Transactional
    public Employee updateEmployeeById(Integer id, Employee updateRequest) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with given id does not exist"));

        // EmployeeShadow empShadow = new EmployeeShadow(
        // employee.getId(),
        // employee.getEmpId(),
        // employee.getFName(),
        // employee.getFullName(), employee.getDob(), employee.getDoj(),
        // employee.getSalary(),
        // employee.getReportsTo(), employee.getDepartments(), employee.getRankId(),
        // employee.getCreateDate(),
        // employee.getUpdateDate(), employee.getClientReqId());

        // employeeShadowRepository.save(empShadow);

        employee.setEmpId(updateRequest.getEmpId());
        employee.setFName(updateRequest.getFName());
        employee.setFullName(updateRequest.getFullName());
        employee.setDob(updateRequest.getDob());
        employee.setDoj(updateRequest.getDoj());
        employee.setSalary(updateRequest.getSalary());
        employee.setReportsTo(updateRequest.getReportsTo());
        employee.setDepartments(updateRequest.getDepartments());
        employee.setDepartments(updateRequest.getDepartments());

        return employeeRepository.save(employee);
    }

}
