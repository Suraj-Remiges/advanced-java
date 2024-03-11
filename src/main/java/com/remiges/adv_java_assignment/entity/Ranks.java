package com.remiges.adv_java_assignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Ranks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rank_desc")
    private String rankDesc;

    @Column(name = "parent_rank_id)                                                                                                                                                             ", length = 50)
    private Integer parentRankId;

}
