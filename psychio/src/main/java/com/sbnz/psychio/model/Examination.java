package com.sbnz.psychio.model;

import java.util.Date;
import java.util.List;

import com.sbnz.psychio.model.enums.SubstanceGroup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Examination {
    private Date date;
    private Double height;
    private Double weight;
    private String comment;
    private List<Symptom> symptoms;
    private List<Statement> statements;
    private List<SubstanceGroup> substances;
}
