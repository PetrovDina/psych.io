package com.sbnz.psychio.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sbnz.psychio.dto.ExaminationDTO;
import com.sbnz.psychio.model.Examination;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ExaminationToExaminationDTO implements Converter<Examination, ExaminationDTO> {
    private DisorderGroupProbabilityToDisorderGroupProbabilityDTO toDgpDTO;
    private StatementResponseToStatementResponseDTO toSrDTO;

    @Override
    public ExaminationDTO convert(Examination source) {
        // TODO add valid info to DTO
        ExaminationDTO dto = new ExaminationDTO(source.getId(), source.getPatient().getUsername(), source.getHeight(),
                source.getWeight(), source.getComment(), source.getDate(), null,
                toDgpDTO.convert(source.getDisorderGroupProbabilities()),
                toSrDTO.convert(source.getStatementResponses()), source.getSubstances());

        return dto;
    }

    public List<ExaminationDTO> convert(List<Examination> examinations) {
        return examinations.stream().map(this::convert).collect(Collectors.toList());
    }

}
