package com.sbnz.psychio.service;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sbnz.psychio.model.Examination;
import com.sbnz.psychio.repository.ExaminationRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ExaminationService {
    @Qualifier("rulesSession")
    private final KieSession rulesSession;
    
    private final ExaminationRepository examinationRepository;
    
    public Examination findById(Integer id) {
        return examinationRepository.findById(id).orElse(null);
    }

    public Examination save(Examination examination) {
        return examinationRepository.save(examination);
    }

    public List<Examination> getAllByPatient(String patientUsername) {
        QueryResults results = rulesSession.getQueryResults("getAllExaminationsByPatient", patientUsername);
		List<Examination> examinations = new ArrayList<>();

        for (QueryResultsRow row : results) {
			Examination examination = (Examination) row.get("$examination");
			examinations.add(examination);
		}

        return examinations;
    }

}
