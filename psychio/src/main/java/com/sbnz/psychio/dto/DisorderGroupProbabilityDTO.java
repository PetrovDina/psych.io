package com.sbnz.psychio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DisorderGroupProbabilityDTO {
    private Integer id;
    private Integer examinationId;
    private String disorderGroupName;
    private Double probability;

}
