package com.sbnz.psychio.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.sbnz.psychio.model.enums.Frequency;
import com.sbnz.psychio.model.enums.StatementResponse;
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
    private HashMap<Symptom, Frequency> symptoms;
    private HashMap<Statement, StatementResponse> statements;
    private List<SubstanceGroup> substances;
}
