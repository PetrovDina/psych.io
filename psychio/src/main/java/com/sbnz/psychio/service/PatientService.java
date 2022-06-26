package com.sbnz.psychio.service;

import java.util.List;

import org.kie.api.runtime.KieContainer;

import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import com.sbnz.psychio.model.Patient;
import com.sbnz.psychio.repository.PatientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PatientService {
    private final KieContainer kieContainer;
    private final PatientRepository patientRepository;

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient findByUsername(String username) {
        return patientRepository.findById(username).orElse(null);
    }

    public Patient classifySeverity(Patient patient) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(patient);
        kieSession.fireAllRules();
        kieSession.dispose();
        return patient;
    }

}
