package com.sbnz.psychio.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sbnz.psychio.dto.ExaminationDTO;
import com.sbnz.psychio.model.Examination;

@Component
public class ExaminationToExaminationDTO
        implements Converter<Examination, ExaminationDTO> {

    @Override
    public ExaminationDTO convert(Examination source) {
        //TODO add valid info to DTO
        return new ExaminationDTO(source.getPatient().getUsername(), source.getHeight(), source.getWeight(), source.getComment(), source.getDate(), null);
    }

    public List<ExaminationDTO> convert(List<Examination> examinations) {
        return examinations.stream().map(this::convert).collect(Collectors.toList());
    }

}
