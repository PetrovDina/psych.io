package com.sbnz.psychio.model;

import java.util.List;

import com.sbnz.psychio.model.enums.TherapyGroup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Therapy {
    private String name;
    private List<TherapyGroup> therapyGroups;
}
