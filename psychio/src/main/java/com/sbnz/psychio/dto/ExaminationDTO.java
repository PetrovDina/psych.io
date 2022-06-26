package com.sbnz.psychio.dto;

import java.util.Date;
import java.util.List;

import com.sbnz.psychio.model.SubstanceGroup;
import com.sbnz.psychio.model.TherapyProbability;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExaminationDTO {
    private Integer id;
    private String username;
    private Double height;
    private Double weight;
    private String comment;
    private Date date;
    private List<SymptomFrequencyDTO> symptoms;
    private List<DisorderGroupProbabilityDTO> disorderGroupProbabilities;
    private List<StatementResponseDTO> statements;
    private List<DiagnosisProbabilityDTO> diagnosisProbabilities;
    private List<SubstanceGroup> substances;
    private List<TherapyProbabilityDTO> therapyProbabilities;

}
