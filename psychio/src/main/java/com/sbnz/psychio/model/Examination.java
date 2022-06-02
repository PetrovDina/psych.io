package com.sbnz.psychio.model;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Examination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Date date;

    @Column
    private Double height;

    @Column
    private Double weight;

    @Column
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "examination")
    private List<SymptomFrequency> symptoms;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "examination")
    private List<StatementResponse> statements;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<SubstanceGroup> substances;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "examination")
    private List<DisorderGroupProbability> disorderGroupProbabilities;

    @Column
    private Boolean disorderGroupsDetermined = false; // za aktivaciju pravila o generisanju kviza na osnovu predvidjene
                                                      // grupe

    @Column
    private Boolean statementsAnswered = false;

    @Column
    private double bmi;

    public Examination(Patient patient, Double height, Double weight, String comment) {
        this.patient = patient;
        this.height = height;
        this.weight = weight;
        this.comment = comment;
        this.date = new Date();
        this.symptoms = new ArrayList<SymptomFrequency>();
        this.disorderGroupProbabilities = new ArrayList<DisorderGroupProbability>();
    }

    public SymptomFrequency getSymptomFrequencyIfPresent(Symptom s) {
        for (SymptomFrequency sf : symptoms) {
            if (sf.getSymptom().equals(s)) { // TODO maybe change to ID check
                return sf;
            }
        }
        return null;
    }

}
