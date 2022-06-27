package com.sbnz.psychio.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class Therapy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "therapy_group_id")
    private TherapyGroup therapyGroup;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "therapy_diagnosis", joinColumns = @JoinColumn(name = "therapy_id"), inverseJoinColumns = @JoinColumn(name = "diagnosis_id"))
    private List<Diagnosis> diagnoses;

    public boolean isDiagnoseOccurent(Diagnosis diagnosis) {
        for (Diagnosis d : diagnoses) {
            if (d.getId().equals(diagnosis.getId())) {
                return true;
            }
        }
        return false;
    }

    public boolean isDiagnoseOccurent(Integer diagnosisId) {
        for (Diagnosis d : diagnoses) {
            if (d.getId().equals(diagnosisId)) {
                return true;
            }
        }
        return false;
    }
}
