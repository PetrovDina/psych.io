package com.sbnz.psychio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbnz.psychio.model.Statement;

public interface StatementRepository extends JpaRepository<Statement, Integer> {

}
