package com.sbnz.psychio.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sbnz.psychio.model.enums.DisorderGroupName;

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

    @Column
    private DisorderGroupName name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "disorderGroup")
    private List<DisorderGroupSymptomOccurence> symptomOccurences;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "disorderGroup")
    private List<Diagnosis> diagnoses;
    
    private boolean isSymptomOccurent(Symptom s) {
    	for (DisorderGroupSymptomOccurence dgso: symptomOccurences) {
    		if (dgso.getSymptom().equals(s) && dgso.getOccurence() > 0) { //TODO maybe change to ID check
    			return true;
    		}
    	}
    	return false;
    }
}
