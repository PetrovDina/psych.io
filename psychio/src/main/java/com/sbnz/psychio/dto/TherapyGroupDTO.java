package com.sbnz.psychio.dto;

import javax.persistence.Enumerated;

import com.sbnz.psychio.model.enums.TherapyGroupName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TherapyGroupDTO {
    private Integer id;

    private TherapyGroupName name;
}