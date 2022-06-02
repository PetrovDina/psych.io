
package com.sbnz.psychio.repository;

import java.util.List;

import com.sbnz.psychio.model.Diagnosis;
import com.sbnz.psychio.model.DisorderGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer> {
    public List<Diagnosis> findByDisorderGroup(DisorderGroup group);
}
