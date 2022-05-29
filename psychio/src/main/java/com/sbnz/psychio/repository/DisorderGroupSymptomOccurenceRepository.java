package com.sbnz.psychio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbnz.psychio.model.DisorderGroupSymptomOccurence;

@Repository
public interface DisorderGroupSymptomOccurenceRepository extends JpaRepository<DisorderGroupSymptomOccurence, Integer> {

}
