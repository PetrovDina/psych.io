

package com.sbnz.psychio.repository;

import com.sbnz.psychio.model.StatementResponse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatementResponseRepository extends JpaRepository<StatementResponse, Integer> {
}
