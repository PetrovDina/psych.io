package com.sbnz.psychio.model;

import com.sbnz.psychio.model.enums.DisorderGroupName;
import com.sbnz.psychio.model.enums.Frequency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Statement {
    private String content;
    private DisorderGroupName disorderGroup;
    private Frequency frequency;
}
