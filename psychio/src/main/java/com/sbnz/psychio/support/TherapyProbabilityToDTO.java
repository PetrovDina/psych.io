
package com.sbnz.psychio.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sbnz.psychio.dto.TherapyProbabilityDTO;
import com.sbnz.psychio.model.TherapyProbability;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class TherapyProbabilityToDTO
        implements Converter<TherapyProbability, TherapyProbabilityDTO> {
    
    private TherapyToTherapyDTO toDTO;

    @Override
    public TherapyProbabilityDTO convert(TherapyProbability source) {
        return new TherapyProbabilityDTO(source.getId(), toDTO.convert(source.getTherapy()), source.getProbability());
    }

    public List<TherapyProbabilityDTO> convert(List<TherapyProbability> probabilities) {
        return probabilities.stream().map(this::convert).collect(Collectors.toList());
    }

}
