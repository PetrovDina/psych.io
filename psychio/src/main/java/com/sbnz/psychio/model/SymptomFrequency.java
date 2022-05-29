package com.sbnz.psychio.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sbnz.psychio.model.enums.Frequency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SymptomFrequency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "symptom_id")
    private Symptom symptom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "examination_id")
    private Examination examination;

    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    public SymptomFrequency(Symptom symptom, Frequency frequency) {
        this.symptom = symptom;
        this.frequency = frequency;
    }
}
