package com.sbnz.psychio.model;

import java.util.List;

import com.sbnz.psychio.model.enums.DisorderGroupName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DisorderGroup {
	private DisorderGroupName name;
	private List<DisorderGroupSymptomOccurence> symptomOccurences;

}
