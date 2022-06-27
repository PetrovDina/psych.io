package com.sbnz.psychio.dto;

import com.sbnz.psychio.model.TherapyGroup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TherapyDTO {
    private Integer id;

    private String name;

    private TherapyGroupDTO therapyGroup;

    // private List<Diagnosis> diagnoses;

    
}
