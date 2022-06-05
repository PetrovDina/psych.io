package com.sbnz.psychio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbnz.psychio.model.DiagnosisProbability;

@Repository
public interface DiagnosisProbabilityRepository extends JpaRepository<DiagnosisProbability, Integer> {

}
