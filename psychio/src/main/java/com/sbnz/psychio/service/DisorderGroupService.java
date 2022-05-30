package com.sbnz.psychio.service;

import java.util.ArrayList;

import java.util.List;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sbnz.psychio.dto.ExaminationDTO;
import com.sbnz.psychio.dto.SymptomFrequencyDTO;
import com.sbnz.psychio.model.DisorderGroup;
import com.sbnz.psychio.model.DisorderGroupProbability;
import com.sbnz.psychio.model.DisorderGroupSymptomOccurence;
import com.sbnz.psychio.model.Examination;
import com.sbnz.psychio.model.Patient;
import com.sbnz.psychio.model.SymptomFrequency;
import com.sbnz.psychio.repository.DisorderGroupRepository;
import com.sbnz.psychio.repository.DisorderGroupSymptomOccurenceRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DisorderGroupService {
    @Qualifier("rulesSession")
    private final KieSession rulesSession;

    private final DisorderGroupRepository disorderGroupRepository;
    private final DisorderGroupSymptomOccurenceRepository disorderGroupSymptomOccurenceRepository;

    private final PatientService patientService;
    private final ExaminationService examinationService;
    private final SymptomService symptomService;

    public List<DisorderGroup> findAll() {
        return disorderGroupRepository.findAll();
    }

    public List<DisorderGroupSymptomOccurence> findAllDisorderGroupSymptomOccurences() {
        return disorderGroupSymptomOccurenceRepository.findAll();
    }

    public List<DisorderGroupProbability> calculateDisorderGroupProbabilites(ExaminationDTO examinationDTO) {
        Patient patient = patientService.findByUsername(examinationDTO.getUsername());
        List<SymptomFrequency> symptoms = new ArrayList<SymptomFrequency>();

        Examination examination = examinationService.save(new Examination(patient, examinationDTO.getHeight(),
                examinationDTO.getWeight(), examinationDTO.getComment()));

        for (SymptomFrequencyDTO symptom : examinationDTO.getSymptoms()) {
            symptoms.add(symptomService.saveSymptomFrequency(new SymptomFrequency(
                    symptomService.findById(symptom.getSymptomId()), examination, symptom.getFrequency())));
        }

        rulesSession.getAgenda().getAgendaGroup("disorder-group-probability").setFocus();
        rulesSession.insert(examination);
        rulesSession.fireAllRules();
        examinationService.save(examination);
        
        System.out.println("Number of objects in session: " + rulesSession.getFactCount()); //ovde bude 1, nema onoga sto smo ubacivali u konfigu

        return examination.getDisorderGroupProbabilities();
    }

}
