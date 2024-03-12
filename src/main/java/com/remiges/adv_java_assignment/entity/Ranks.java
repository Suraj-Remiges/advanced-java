package com.remiges.adv_java_assignment.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Ranks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rank_desc")
    private String rankDesc;

    @OneToMany(mappedBy = "rankId", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonBackReference
    private List<Employee> employee;

}
