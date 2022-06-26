package com.sbnz.psychio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.sbnz.psychio.model.SubstanceGroup;

@Repository
public interface SubstanceGroupRepository extends JpaRepository<SubstanceGroup, Integer> {

}
