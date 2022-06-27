package com.sbnz.psychio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TherapyProbabilityDTO {
    private Integer id;

    private TherapyDTO therapy;

    private Double probability;
}
