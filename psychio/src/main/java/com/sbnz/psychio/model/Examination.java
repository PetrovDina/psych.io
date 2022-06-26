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
    private List<StatementResponse> statementResponses;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<SubstanceGroup> substances;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "examination")
    private List<DisorderGroupProbability> disorderGroupProbabilities;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "examination")
    private List<DiagnosisProbability> diagnosisProbabilities;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "examination")
    private List<TherapyProbability> therapyProbabilities;

    @Column
    private Boolean disorderGroupsDetermined = false; // za aktivaciju pravila o generisanju kviza na osnovu predvidjene
                                                      // grupe

    @Column
    private Boolean statementsAnswered = false; // false until the patient sends back completed quiz, then set it to
                                                // true!
    @Column
    private Boolean diagnosesDetermined = false;

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
        this.statementResponses = new ArrayList<StatementResponse>();
        this.diagnosisProbabilities = new ArrayList<DiagnosisProbability>();
        this.therapyProbabilities = new ArrayList<TherapyProbability>();
    }

}
