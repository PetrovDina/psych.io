package com.sbnz.psychio.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import com.sbnz.psychio.model.Patient;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PatientService {
    private final KieContainer kieContainer;

    public Patient classifySeverity(Patient patient) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(patient);
        kieSession.fireAllRules();
        kieSession.dispose();
        return patient;
    }

}
