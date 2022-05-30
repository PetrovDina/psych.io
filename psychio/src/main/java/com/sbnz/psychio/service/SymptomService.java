package com.sbnz.psychio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sbnz.psychio.model.Symptom;
import com.sbnz.psychio.model.SymptomFrequency;
import com.sbnz.psychio.repository.SymptomFrequencyRepository;
import com.sbnz.psychio.repository.SymptomRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SymptomService {
    private final SymptomRepository symptomRepository;
    private final SymptomFrequencyRepository symptomFrequencyRepository;

    public List<Symptom> findAll() {
        return symptomRepository.findAll();
    }

    public Symptom findById(Integer id) {
        return symptomRepository.findById(id).orElse(null);
    }

    public SymptomFrequency saveSymptomFrequency(SymptomFrequency symptomFrequency) {
        return symptomFrequencyRepository.save(symptomFrequency);
    }

}
