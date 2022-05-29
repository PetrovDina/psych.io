package com.sbnz.psychio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbnz.psychio.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

}
