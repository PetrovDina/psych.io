package com.sbnz.psychio.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import com.sbnz.psychio.dto.DisorderGroupSymptomOccurenceDTO;
import com.sbnz.psychio.model.DisorderGroupSymptomOccurence;

@Component
public class DisorderGroupSymptomOccurenceToDto
        implements Converter<DisorderGroupSymptomOccurence, DisorderGroupSymptomOccurenceDTO> {

    
    @Autowired
    private SymptomToSymptomDTO sympToDTO;

    @Override
    public DisorderGroupSymptomOccurenceDTO convert(DisorderGroupSymptomOccurence source) {
        //TODO add valid info to DTO
        return new DisorderGroupSymptomOccurenceDTO(source.getId(), source.getDisorderGroup().getId(), sympToDTO.convert(source.getSymptom()), source.getOccurence());
    }

    public List<DisorderGroupSymptomOccurenceDTO> convert(List<DisorderGroupSymptomOccurence> probabilities) {
        return probabilities.stream().map(this::convert).collect(Collectors.toList());
    }

}
