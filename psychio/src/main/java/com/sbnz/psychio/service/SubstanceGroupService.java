package com.sbnz.psychio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sbnz.psychio.model.SubstanceGroup;
import com.sbnz.psychio.repository.SubstanceGroupRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SubstanceGroupService {
    private final SubstanceGroupRepository substanceGroupRepository;

    public List<SubstanceGroup> findAll() {
        return substanceGroupRepository.findAll();
    }

}
