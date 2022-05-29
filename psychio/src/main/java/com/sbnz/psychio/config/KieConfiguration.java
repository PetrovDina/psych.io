package com.sbnz.psychio.config;

import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sbnz.psychio.model.DisorderGroup;
import com.sbnz.psychio.model.DisorderGroupSymptomOccurence;
import com.sbnz.psychio.model.Symptom;
import com.sbnz.psychio.repository.DisorderGroupRepository;
import com.sbnz.psychio.repository.DisorderGroupSymptomOccurenceRepository;
import com.sbnz.psychio.repository.SymptomRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class KieConfiguration {

    private final DisorderGroupRepository disorderGroupRepository;
    private final SymptomRepository symptomRepositiry;
    private final DisorderGroupSymptomOccurenceRepository disorderGroupSymptomOccurencRepository;

    @Bean
    public KieContainer kieContainer() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieContainer(ks.newReleaseId("com.sbnz", "psychio-kjar", "0.0.1-SNAPSHOT"));
        KieScanner kScanner = ks.newKieScanner(kContainer);
        kScanner.start(10_000);
        return kContainer;
    }

    @Bean(name = "rulesSession")
    public KieSession kieSession() {
        KieSession kieSession = this.kieContainer().newKieSession("rulesSession");
        // kieSession.setGlobal('naziv', 'vrednost'); koristi se za postavljanje
        // globalnih vrednosti na noviu sesije

        List<DisorderGroup> disorderGroups = disorderGroupRepository.findAll();
        for (DisorderGroup disorderGroup : disorderGroups) {
            kieSession.insert(disorderGroup);
        }

        List<Symptom> symptoms = symptomRepositiry.findAll();
        for (Symptom symptom : symptoms) {
            kieSession.insert(symptom);
        }

        List<DisorderGroupSymptomOccurence> disorderGroupSymptomOccurences = disorderGroupSymptomOccurencRepository
                .findAll();
        for (DisorderGroupSymptomOccurence disorderGroupSymptomOccurence : disorderGroupSymptomOccurences) {
            kieSession.insert(disorderGroupSymptomOccurence);
        }

        return kieSession;
    }

}
