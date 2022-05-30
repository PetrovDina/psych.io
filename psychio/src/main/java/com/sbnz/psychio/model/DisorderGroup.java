package com.sbnz.psychio.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sbnz.psychio.model.enums.DisorderGroupName;
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
public class DisorderGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private DisorderGroupName name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "disorderGroup")
    private List<DisorderGroupSymptomOccurence> symptomOccurences;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "disorderGroup")
    private List<Diagnosis> diagnoses;

    public boolean isSymptomOccurent(Symptom s) {
        for (DisorderGroupSymptomOccurence dgso : symptomOccurences) {
            if (dgso.getSymptom().getId().equals(s.getId()) && dgso.getOccurence() > 0) {
                return true;
            }
        }
        return false;
    }

    public double getMinimumScore() {
        int maxScore = 0;
        for (DisorderGroupSymptomOccurence dsgo : symptomOccurences) {
            maxScore += dsgo.getOccurence() * Frequency.OFTEN.ordinal();
        }
        return 0.1 * maxScore; // 10% of max score

    }

    public int getSymptomOccurence(Symptom s) {
        for (DisorderGroupSymptomOccurence dgso : symptomOccurences) {
            if (dgso.getSymptom().getId().equals(s.getId()) && dgso.getOccurence() > 0) {
                return dgso.getOccurence();
            }
        }
        return 0;
    }

}
