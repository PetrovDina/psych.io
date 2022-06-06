package com.sbnz.psychio.config;

import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sbnz.psychio.model.Diagnosis;
import com.sbnz.psychio.model.DisorderGroup;
import com.sbnz.psychio.model.DisorderGroupSymptomOccurence;
import com.sbnz.psychio.model.Statement;
import com.sbnz.psychio.model.Symptom;
import com.sbnz.psychio.repository.DiagnosisRepository;
import com.sbnz.psychio.repository.DisorderGroupRepository;
import com.sbnz.psychio.repository.DisorderGroupSymptomOccurenceRepository;
import com.sbnz.psychio.repository.StatementRepository;
import com.sbnz.psychio.repository.SymptomRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class KieConfiguration {

    private final DisorderGroupRepository disorderGroupRepository;
    private final SymptomRepository symptomRepositiry;
    private final DisorderGroupSymptomOccurenceRepository disorderGroupSymptomOccurencRepository;
    private final DiagnosisRepository diagnosisRepository;
    private final StatementRepository statementRepository;

    @Bean
    public KieContainer kieContainer() {
        KieServices ks = KieServices.Factory.get();
        // KieContainer kContainer = ks.newKieContainer(ks.newReleaseId("com.sbnz",
        // "psychio-kjar", "0.0.1-SNAPSHOT"));
        KieContainer kContainer = ks.getKieClasspathContainer();
        // KieScanner kScanner = ks.newKieScanner(kContainer);
        // kScanner.start(10_000);
        return kContainer;
    }

    @Bean(name = "cepSession")
    public KieSession eventsSession() {
        KieSession kieSession = this.kieContainer().newKieSession("cepSession");
        return kieSession;
    }

    @Bean(name = "rulesSession")
    public KieSession kieSession() {
        KieSession kieSession = this.kieContainer().newKieSession("rulesSession");
        // kieSession.setGlobal('naziv', 'vrednost'); koristi se za postavljanje
        // globalnih vrednosti na noviu sesije

        List<DisorderGroup> disorderGroups = disorderGroupRepository.findAll();
        System.out.println(disorderGroups.size() + " disorder groups");
        for (DisorderGroup disorderGroup : disorderGroups) {
            kieSession.insert(disorderGroup);
        }

        List<Symptom> symptoms = symptomRepositiry.findAll();
        System.out.println(symptoms.size() + " symptoms");

        for (Symptom symptom : symptoms) {
            kieSession.insert(symptom);
        }

        List<DisorderGroupSymptomOccurence> disorderGroupSymptomOccurences = disorderGroupSymptomOccurencRepository
                .findAll();
        for (DisorderGroupSymptomOccurence disorderGroupSymptomOccurence : disorderGroupSymptomOccurences) {
            kieSession.insert(disorderGroupSymptomOccurence);
        }

        for (Diagnosis diagnosis : diagnosisRepository.findAll()) {
            kieSession.insert(diagnosis);
        }

        for (Statement statement : statementRepository.findAll()) {
            kieSession.insert(statement);
        }

        System.out.println("Number of objects in config: " + kieSession.getObjects().size());

        return kieSession;
    }

}
