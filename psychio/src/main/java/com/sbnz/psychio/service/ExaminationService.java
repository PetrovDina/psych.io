package com.sbnz.psychio.service;

import org.springframework.stereotype.Service;

import com.sbnz.psychio.model.Examination;
import com.sbnz.psychio.repository.ExaminationRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ExaminationService {
    private final ExaminationRepository examinationRepository;

    public Examination save(Examination examination) {
        return examinationRepository.save(examination);
    }

}
