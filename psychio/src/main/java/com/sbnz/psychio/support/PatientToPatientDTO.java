package com.sbnz.psychio.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sbnz.psychio.dto.PatientDTO;
import com.sbnz.psychio.model.Patient;

@Component
public class PatientToPatientDTO
        implements Converter<Patient, PatientDTO> {

    @Override
    public PatientDTO convert(Patient source) {
        PatientDTO p =  new PatientDTO(source.getFirstName(), source.getLastName(), source.getBirthDate(), source.getGender(),
                source.getSeverity(), source.getMaritalStatus(), source.getEmploymentStatus());
        p.setUsername(source.getUsername());
        return p;
            
    }

    public List<PatientDTO> convert(List<Patient> patients) {
        return patients.stream().map(this::convert).collect(Collectors.toList());
    }

}