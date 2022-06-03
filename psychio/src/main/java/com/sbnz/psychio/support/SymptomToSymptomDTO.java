package com.sbnz.psychio.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sbnz.psychio.dto.SymptomDTO;
import com.sbnz.psychio.model.Symptom;

@Component
public class SymptomToSymptomDTO
        implements Converter<Symptom, SymptomDTO> {

    @Override
    public SymptomDTO convert(Symptom source) {
        return new SymptomDTO(source.getId(), source.getDescription());
    }

    public List<SymptomDTO> convert(List<Symptom> probabilities) {
        return probabilities.stream().map(this::convert).collect(Collectors.toList());
    }

}
