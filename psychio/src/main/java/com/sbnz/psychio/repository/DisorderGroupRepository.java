package com.sbnz.psychio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbnz.psychio.model.DisorderGroup;

@Repository
public interface DisorderGroupRepository extends JpaRepository<DisorderGroup, Integer> {

}
