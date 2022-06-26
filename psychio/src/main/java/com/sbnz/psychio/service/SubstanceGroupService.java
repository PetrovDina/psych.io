package com.sbnz.psychio.service;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sbnz.psychio.model.DisorderGroupSymptomOccurence;
import com.sbnz.psychio.model.SubstanceGroup;
import com.sbnz.psychio.model.Therapy;
import com.sbnz.psychio.repository.SubstanceGroupRepository;
import com.sbnz.psychio.repository.SymptomRepository;
import com.sbnz.psychio.repository.TherapyRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SubstanceGroupService {
    @Qualifier("rulesSession")
    private final KieSession rulesSession;
    private final TherapyRepository therapyRepository;
    private final SubstanceGroupRepository substanceGroupRepository;

    public List<SubstanceGroup> findAll() {
        return substanceGroupRepository.findAll();
    }

    public List<Therapy> queryTherapiesByDiagnosis(Integer diagnosisId) {
        QueryResults results = rulesSession.getQueryResults("getAllTherapiesByDiagnosis", diagnosisId);
		List<Therapy> therapies = new ArrayList<>();

        for (QueryResultsRow row : results) {
			Therapy therapy = (Therapy) row.get("$therapy");
			therapies.add(therapy);
		}

        return therapies;
    }

    public List<Therapy> getAllTherapies() {
        return therapyRepository.findAll();
    }
}
