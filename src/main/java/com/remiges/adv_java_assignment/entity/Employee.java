package com.remiges.adv_java_assignment.entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "employee")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String emp_id;

    @Column(nullable = false)
    private String f_name;

    @Column(nullable = false)
    private String full_name;

    @Column(nullable = false)
    private Date dob;

    @Column(nullable = false)
    private Date doj;

    @Column(nullable = false)
    private Integer salary;

    private Integer reports_to;

    private Integer dept_id;

    private Integer rank_id;

    @CreationTimestamp
    private java.util.Date create_date;

    @UpdateTimestamp
    private java.util.Date update_date;

    @UuidGenerator
    private String client_reqid;

    public Employee(Integer id, String emp_id, String f_name, String full_name, Date dob, Date doj, Integer salary,
            Integer reports_to, Integer dept_id, Integer rank_id, java.util.Date create_date,
            java.util.Date update_date, String client_reqid) {
        this.id = id;
        this.emp_id = emp_id;
        this.f_name = f_name;
        this.full_name = full_name;
        this.dob = dob;
        this.doj = doj;
        this.salary = salary;
        this.reports_to = reports_to;
        this.dept_id = dept_id;
        this.rank_id = rank_id;
        this.create_date = create_date;
        this.update_date = update_date;
        this.client_reqid = client_reqid;
    }

}
