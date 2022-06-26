package com.sbnz.psychio.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sbnz.psychio.model.Patient;
import com.sbnz.psychio.model.Report;
import com.sbnz.psychio.repository.PatientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PatientService {
    private final KieContainer kieContainer;
    private final PatientRepository patientRepository;
    @Qualifier(value = "rulesSession")
	private KieSession rulesSession;

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }
    
    public Patient findByUsername(String username) {
        return patientRepository.findById(username).orElse(null);
    }

    public List<Patient> findBmiGoingLowerPatients() {
        Set<Patient> patientReport = new HashSet<Patient>();
		rulesSession.setGlobal("patientReport", patientReport);
		rulesSession.getAgenda().getAgendaGroup("bmi-report").setFocus();
        rulesSession.insert(new Report());
		rulesSession.fireAllRules();
        List<Patient> list = new ArrayList<>();
        list.addAll(patientReport);
		return list;
    }

    public Patient classifySeverity(Patient patient) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(patient);
        kieSession.fireAllRules();
        kieSession.dispose();
        return patient;
    }

}
