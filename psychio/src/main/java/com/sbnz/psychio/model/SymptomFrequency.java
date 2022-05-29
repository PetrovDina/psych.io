package com.sbnz.psychio.model;

import java.util.Date;
import java.util.List;

import com.sbnz.psychio.model.enums.Frequency;
import com.sbnz.psychio.model.enums.SubstanceGroup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SymptomFrequency {
	private Symptom symptom;
	private Frequency frequency;

}
