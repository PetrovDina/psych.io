package com.sbnz.psychio.service;

import java.util.List;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sbnz.psychio.dto.ExaminationDTO;
import com.sbnz.psychio.dto.StatementResponseDTO;
import com.sbnz.psychio.model.DiagnosisProbability;
import com.sbnz.psychio.model.Examination;
import com.sbnz.psychio.model.StatementResponse;
import com.sbnz.psychio.repository.DiagnosisProbabilityRepository;
import com.sbnz.psychio.repository.StatementResponseRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DiagnosisService {
    @Qualifier("rulesSession")
    private final KieSession rulesSession;

    private final DiagnosisProbabilityRepository diagnosisProbabilityRepository;
    private final StatementResponseRepository statementResponseRepository;

    private final ExaminationService examinationService;

    public void saveDiagnosisProbabilities(List<DiagnosisProbability> probabilities) {
        for (DiagnosisProbability probability : probabilities) {
            diagnosisProbabilityRepository.save(probability);
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
        rulesSession.insert(examination);
        rulesSession.fireAllRules();

        saveDiagnosisProbabilities(examination.getDiagnosisProbabilities());
        examinationService.save(examination);

        return examination.getDiagnosisProbabilities();

    }

}
