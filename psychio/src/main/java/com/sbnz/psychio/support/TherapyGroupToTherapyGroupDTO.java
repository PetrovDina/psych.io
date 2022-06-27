
package com.sbnz.psychio.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sbnz.psychio.dto.SymptomDTO;
import com.sbnz.psychio.dto.TherapyGroupDTO;
import com.sbnz.psychio.model.TherapyGroup;


@Component
public class TherapyGroupToTherapyGroupDTO
        implements Converter<TherapyGroup, TherapyGroupDTO> {

    @Override
    public TherapyGroupDTO convert(TherapyGroup source) {
        return new TherapyGroupDTO(source.getId(), source.getName());
    }

    public List<TherapyGroupDTO> convert(List<TherapyGroup> probabilities) {
        return probabilities.stream().map(this::convert).collect(Collectors.toList());
    }
}