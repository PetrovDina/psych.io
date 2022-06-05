package com.sbnz.psychio.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sbnz.psychio.dto.DiagnosisProbabilityDTO;
import com.sbnz.psychio.model.DiagnosisProbability;

@Component
public class DiagnosisProbabilityToDiagnosisProbabilityDTO
        implements Converter<DiagnosisProbability, DiagnosisProbabilityDTO> {

    @Override
    public DiagnosisProbabilityDTO convert(DiagnosisProbability source) {
        return new DiagnosisProbabilityDTO(source.getId(), source.getDiagnosis().getId(),
                source.getDiagnosis().getName(), source.getProbability());
    }

    public List<DiagnosisProbabilityDTO> convert(List<DiagnosisProbability> probabilities) {
        return probabilities.stream().map(this::convert).collect(Collectors.toList());
    }

}
