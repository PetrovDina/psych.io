package com.sbnz.psychio.model;

import com.sbnz.psychio.model.enums.DisorderGroup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Diagnosis {
    private String name;
    private DisorderGroup disorderGroup;
}
