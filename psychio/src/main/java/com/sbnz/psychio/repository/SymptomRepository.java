package com.sbnz.psychio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbnz.psychio.model.Symptom;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom, Integer> {

}
