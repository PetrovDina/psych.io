package com.sbnz.psychio.model;

import java.util.Date;
import java.util.List;

import com.sbnz.psychio.model.enums.SubstanceGroup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Examination {
    private Date date;
    private Double height;
    private Double weight;
    private String comment;
    private List<SymptomFrequency> symptoms;
    private List<StatementResponse> statements;
    private List<SubstanceGroup> substances;
    private boolean disorderGroupsDetermined = false; // za aktivaciju pravila o generisanju kviza na osnovu predvidjene grupe


    private SymptomFrequency getSymptomFrequencyIfPresent(Symptom s) {
    	for (SymptomFrequency sf: symptoms) {
    		if (sf.getSymptom().equals(s)) {
    			return sf;
    		}
    	}
    	return null;
    }
}
