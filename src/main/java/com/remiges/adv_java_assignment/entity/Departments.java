package com.remiges.adv_java_assignment.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "departments")
@Data
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dept_name")
    private String deptName;

    // @OneToMany(mappedBy = "departments", cascade = CascadeType.ALL)
    // @ToString.Exclude
    // @JsonBackReference
    // private List<Employee> employeess;

    // src/main/java/com/remiges/adv_java_assignment/entity/Departments.java
    // /home/surajg/Assignments/hello_world/adv_java_assignment/src/main/java/com/remiges/adv_java_assignment/entity/Departments.java

}
