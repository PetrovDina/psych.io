package com.sbnz.psychio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisProbabilityDTO {
    private Integer id;
    private Integer diagnosisId;
    private String diagnosisName;
    private Double probability;
}
