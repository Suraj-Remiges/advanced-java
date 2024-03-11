package com.remiges.adv_java_assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remiges.adv_java_assignment.entity.Employee;

//Employee Repository extending JpaRepository
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
