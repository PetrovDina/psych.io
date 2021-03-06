package com.sbnz.psychio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DisorderGroupSymptomOccurence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disorder_group_id")
    private DisorderGroup disorderGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "symptom_id")
    private Symptom symptom;

    @Column
    private Integer occurence;
}
