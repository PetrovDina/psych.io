package com.sbnz.psychio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbnz.psychio.model.Examination;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Integer> {

}
