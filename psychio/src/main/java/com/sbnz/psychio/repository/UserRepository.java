package com.sbnz.psychio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbnz.psychio.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
