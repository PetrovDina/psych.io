package com.sbnz.psychio.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sbnz.psychio.dto.DisorderGroupProbabilityDTO;
import com.sbnz.psychio.model.DisorderGroupProbability;

@Component
public class DisorderGroupProbabilityToDisorderGroupProbabilityDTO
        implements Converter<DisorderGroupProbability, DisorderGroupProbabilityDTO> {

    @Override
    public DisorderGroupProbabilityDTO convert(DisorderGroupProbability source) {
        return new DisorderGroupProbabilityDTO(source.getId(), source.getExamination().getId(),
                source.getDisorderGroup().getName().name(), source.getProbability());
    }

    public List<DisorderGroupProbabilityDTO> convert(List<DisorderGroupProbability> probabilities) {
        return probabilities.stream().map(this::convert).collect(Collectors.toList());
    }

}
