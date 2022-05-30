package com.sbnz.psychio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbnz.psychio.model.DisorderGroupProbability;

@Repository
public interface DisorderGroupProbabilityRepository extends JpaRepository<DisorderGroupProbability, Integer> {

}
