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
// Emplyee entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, name = "emp_id")
    private String empId;

    @Column(nullable = false, name = "f_name")
    private String fName;

    @Column(nullable = false, name = "full_name")
    private String fullName;

    @Column(nullable = false)
    private Date dob;

    @Column(nullable = false)
    private Date doj;

    @Column(nullable = false)
    private Integer salary;

    @Column(name = "reports_to")
    private Integer reportsTo;

    @Column(name = "dept_id")
    private Integer deptId;

    @Column(name = "rank_id")
    private Integer rankId;

    @CreationTimestamp
    @Column(name = "create_date")
    private java.util.Date createDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private java.util.Date updateDate;

    @UuidGenerator
    @Column(name = "client_reqid")
    private String clientReqId;

    // Constructor
    public Employee(Integer id, String empId, String fName, String fullName, Date dob, Date doj, Integer salary,
            Integer reportsTo, Integer deptId, Integer rankId, java.util.Date createDate, java.util.Date updateDate,
            String clientReqId) {
        this.id = id;
        this.empId = empId;
        this.fName = fName;
        this.fullName = fullName;
        this.dob = dob;
        this.doj = doj;
        this.salary = salary;
        this.reportsTo = reportsTo;
        this.deptId = deptId;
        this.rankId = rankId;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.clientReqId = clientReqId;
    }

    public String getFullName() {
        return fullName;
    }

    // Default constructor
    public Employee() {
    }

}
