
package com.sbnz.psychio.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sbnz.psychio.dto.SymptomFrequencyDTO;
import com.sbnz.psychio.model.SymptomFrequency;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SymptomFrequencyToDTO implements Converter<SymptomFrequency, SymptomFrequencyDTO> {

    private final SymptomToSymptomDTO toDTO;

    @Override
    public SymptomFrequencyDTO convert(SymptomFrequency source) {
        return new SymptomFrequencyDTO(source.getSymptom().getId(), toDTO.convert(source.getSymptom()), source.getFrequency());
    }

    public List<SymptomFrequencyDTO> convert(List<SymptomFrequency> probabilities) {
        return probabilities.stream().map(this::convert).collect(Collectors.toList());
    }

}