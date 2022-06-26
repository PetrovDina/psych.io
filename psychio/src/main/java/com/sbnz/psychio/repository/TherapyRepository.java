package com.sbnz.psychio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbnz.psychio.model.Therapy;

@Repository
public interface TherapyRepository extends JpaRepository<Therapy, String> {

}
