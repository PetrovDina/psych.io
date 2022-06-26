package com.sbnz.psychio.service;

import java.util.ArrayList;
import java.util.List;

import com.sbnz.psychio.dto.ExaminationDTO;
import com.sbnz.psychio.dto.SymptomFrequencyDTO;
import com.sbnz.psychio.model.Diagnosis;
import com.sbnz.psychio.model.DisorderGroup;
import com.sbnz.psychio.model.DisorderGroupProbability;
import com.sbnz.psychio.model.DisorderGroupSymptomOccurence;
import com.sbnz.psychio.model.Examination;
import com.sbnz.psychio.model.Patient;
import com.sbnz.psychio.model.Statement;
import com.sbnz.psychio.model.StatementResponse;
import com.sbnz.psychio.model.SymptomFrequency;
import com.sbnz.psychio.model.enums.Response;
import com.sbnz.psychio.model.events.ExaminationEvent;
import com.sbnz.psychio.repository.DiagnosisRepository;
import com.sbnz.psychio.repository.DisorderGroupProbabilityRepository;
import com.sbnz.psychio.repository.DisorderGroupRepository;
import com.sbnz.psychio.repository.DisorderGroupSymptomOccurenceRepository;
import com.sbnz.psychio.repository.StatementResponseRepository;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DisorderGroupService {
    @Qualifier("rulesSession")
    private final KieSession rulesSession;

    @Qualifier("cepSession")
    private final KieSession cepSession;

    private final DisorderGroupRepository disorderGroupRepository;
    private final DisorderGroupProbabilityRepository disorderGroupProbabilityRepository;
    private final DisorderGroupSymptomOccurenceRepository disorderGroupSymptomOccurenceRepository;
    private final DiagnosisRepository diagnosisRepository;
    private final StatementResponseRepository statementResponseRepository;

    private final PatientService patientService;
    private final ExaminationService examinationService;
    private final SymptomService symptomService;

    public List<DisorderGroup> findAll() {
        return disorderGroupRepository.findAll();
    }

    public List<DisorderGroupSymptomOccurence> findAllDisorderGroupSymptomOccurences() {
        return disorderGroupSymptomOccurenceRepository.findAll();
    }

    public void saveDisorderGroupProbabilities(List<DisorderGroupProbability> probabilities) {
        for (DisorderGroupProbability probability : probabilities) {
            disorderGroupProbabilityRepository.save(probability);
        }
    }

    public Examination calculateDisorderGroupProbabilites(ExaminationDTO examinationDTO) {

        Patient patient = patientService.findByUsername(examinationDTO.getUsername());
        List<SymptomFrequency> symptoms = new ArrayList<SymptomFrequency>();

        Examination examination = examinationService.save(new Examination(patient, examinationDTO.getHeight(),
                examinationDTO.getWeight(), examinationDTO.getComment(), examinationDTO.getSubstances()));

        for (SymptomFrequencyDTO symptom : examinationDTO.getSymptoms()) {
            symptoms.add(symptomService.saveSymptomFrequency(new SymptomFrequency(
                    symptomService.findById(symptom.getSymptomId()), examination, symptom.getFrequency())));
        }
        examination.setSymptoms(symptoms);

        rulesSession.getAgenda().getAgendaGroup("disorder-group-probability").setFocus();
        FactHandle examinationHandle = rulesSession.insert(examination);
        rulesSession.fireAllRules();

        saveDisorderGroupProbabilities(examination.getDisorderGroupProbabilities());

        // TODO Do we have to make generating statements a drools rule or like this : ?
        for (DisorderGroupProbability predictedGroupProbability : examination.getDisorderGroupProbabilities()) {
            List<Diagnosis> diagnoses = diagnosisRepository
                    .findByDisorderGroup(predictedGroupProbability.getDisorderGroup());
            for (Diagnosis diagnosis : diagnoses) {
                for (Statement statement : diagnosis.getStatements()) {
                    StatementResponse response = new StatementResponse();
                    response.setStatement(statement);
                    response.setResponse(Response.NA);
                    response.setExamination(examination);
                    examination.getStatementResponses().add(response);

                    // saving new response objects to repo
                    statementResponseRepository.save(response);

                }
            }

        }

        cepSession.insert(new ExaminationEvent(examination.getPatient().getUsername(), examination.getComment(),
                examination.getSymptoms()));
        cepSession.fireAllRules();

        rulesSession.delete(examinationHandle);
        examination.setDisorderGroupsDetermined(true);

        return examinationService.save(examination);
    }

}
