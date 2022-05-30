package com.sbnz.psychio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbnz.psychio.model.SymptomFrequency;

@Repository
public interface SymptomFrequencyRepository extends JpaRepository<SymptomFrequency, Integer> {

}
