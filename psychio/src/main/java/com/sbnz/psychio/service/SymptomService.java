package com.sbnz.psychio.service;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sbnz.psychio.model.Symptom;
import com.sbnz.psychio.model.SymptomFrequency;
import com.sbnz.psychio.repository.SymptomFrequencyRepository;
import com.sbnz.psychio.repository.SymptomRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SymptomService {
    @Qualifier("rulesSession")
    private final KieSession rulesSession;
    private final SymptomRepository symptomRepository;
    private final SymptomFrequencyRepository symptomFrequencyRepository;

    public List<Symptom> findAll() {
        return symptomRepository.findAll();
    }

    public List<Symptom> queryAll() {
        QueryResults results = rulesSession.getQueryResults("getAllSymptoms");
		List<Symptom> symptoms = new ArrayList<>();

        for (QueryResultsRow row : results) {
			Symptom symptom = (Symptom) row.get("$symptom");
			symptoms.add(symptom);
		}

        return symptoms;
    }

    public Symptom findById(Integer id) {
        return symptomRepository.findById(id).orElse(null);
    }

    public SymptomFrequency saveSymptomFrequency(SymptomFrequency symptomFrequency) {
        return symptomFrequencyRepository.save(symptomFrequency);
    }

}
