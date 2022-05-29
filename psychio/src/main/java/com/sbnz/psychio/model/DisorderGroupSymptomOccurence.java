package com.sbnz.psychio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DisorderGroupSymptomOccurence {
	private DisorderGroup disorderGroup;
	private Symptom symptom;
	private int occurence;

}
