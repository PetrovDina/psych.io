package com.sbnz.psychio.dto;

import com.sbnz.psychio.model.enums.Frequency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SymptomFrequencyDTO {
    private Integer symptomId;
    private SymptomDTO symptom;
    private Frequency frequency;
}
