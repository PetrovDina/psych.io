package com.sbnz.psychio.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sbnz.psychio.dto.TherapyDTO;
import com.sbnz.psychio.model.Therapy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class TherapyToTherapyDTO
        implements Converter<Therapy, TherapyDTO> {

    private TherapyGroupToTherapyGroupDTO toDTO;
    @Override
    public TherapyDTO convert(Therapy source) {
        return new TherapyDTO(source.getId(), source.getName(), toDTO.convert(source.getTherapyGroup()));
    }

    public List<TherapyDTO> convert(List<Therapy> probabilities) {
        return probabilities.stream().map(this::convert).collect(Collectors.toList());
    }

}