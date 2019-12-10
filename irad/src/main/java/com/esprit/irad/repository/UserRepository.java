package com.esprit.irad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.irad.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}