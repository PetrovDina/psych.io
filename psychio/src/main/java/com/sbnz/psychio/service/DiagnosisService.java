package com.sbnz.psychio.service;

import java.util.List;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sbnz.psychio.dto.ExaminationDTO;
import com.sbnz.psychio.dto.StatementResponseDTO;
import com.sbnz.psychio.model.DiagnosisProbability;
import com.sbnz.psychio.model.Examination;
import com.sbnz.psychio.model.StatementResponse;
import com.sbnz.psychio.model.TherapyProbability;
import com.sbnz.psychio.model.enums.Severity;
import com.sbnz.psychio.model.events.CriticalEvent;
import com.sbnz.psychio.repository.DiagnosisProbabilityRepository;
import com.sbnz.psychio.repository.StatementResponseRepository;
import com.sbnz.psychio.repository.TherapyProbabilityRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DiagnosisService {
    @Qualifier("rulesSession")
    private final KieSession rulesSession;

    @Qualifier("cepSession")
    private final KieSession cepSession;

    private final DiagnosisProbabilityRepository diagnosisProbabilityRepository;
    private final StatementResponseRepository statementResponseRepository;
    private final TherapyProbabilityRepository therapyProbabilityRepository;

    private final ExaminationService examinationService;
    private final PatientService patientService;

    public void saveDiagnosisProbabilities(List<DiagnosisProbability> probabilities) {
        for (DiagnosisProbability probability : probabilities) {
            diagnosisProbabilityRepository.save(probability);
        }
    }

    public void saveTherapyProbabilities(List<TherapyProbability> probabilities) {
        for (TherapyProbability probability : probabilities) {
            therapyProbabilityRepository.save(probability);
        }
    }

    public List<DiagnosisProbability> calucateDiagnosisProbabilities(ExaminationDTO examinationDTO) {
        Examination examination = examinationService.findById(examinationDTO.getId());
        examination.setStatementsAnswered(true);

        for (StatementResponseDTO responseDTO : examinationDTO.getStatements()) {
            StatementResponse response = statementResponseRepository.findById(responseDTO.getId()).orElse(null);
            response.setResponse(responseDTO.getResponse());
            statementResponseRepository.save(response);
        }
        examinationService.save(examination);

        rulesSession.getAgenda().getAgendaGroup("diagnosis-probability").setFocus();
        FactHandle examinationHandle = rulesSession.insert(examination);
        rulesSession.fireAllRules();

        rulesSession.delete(examinationHandle);

        examination.setDiagnosesDetermined(true);
        saveDiagnosisProbabilities(examination.getDiagnosisProbabilities());
        examination = examinationService.save(examination);

        setTherapyRecommendation(examination);

        return examination.getDiagnosisProbabilities();

    }

    private void setTherapyRecommendation(Examination examination) {
        rulesSession.getAgenda().getAgendaGroup("therapy-probability").setFocus();
        rulesSession.insert(examination);
        rulesSession.fireAllRules();

        saveTherapyProbabilities(examination.getTherapyProbabilities());

        examinationService.save(examination);
        patientService.save(examination.getPatient());

        CriticalEvent criticalEvent = new CriticalEvent(examination.getPatient().getUsername(),
                examination.getComment(), examination.getSymptoms());

        FactHandle factHandle = cepSession.insert(criticalEvent);
        int fired = cepSession.fireAllRules();

        if (fired > 0) {
            examination.getPatient().setSeverity(Severity.CRITICAL);
            patientService.save(examination.getPatient());
        }
        cepSession.delete(factHandle);
    }

}
