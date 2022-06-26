package com.sbnz.psychio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbnz.psychio.model.TherapyProbability;

@Repository
public interface TherapyProbabilityRepository extends JpaRepository<TherapyProbability, Integer> {

}
