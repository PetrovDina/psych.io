package com.sbnz.psychio.model;

import java.util.List;

import com.sbnz.psychio.model.enums.DisorderGroup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Symptom {
    private String name;
    private List<DisorderGroup> disorderGroups;
}
