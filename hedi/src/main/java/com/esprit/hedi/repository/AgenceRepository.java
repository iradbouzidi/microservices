package com.esprit.hedi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.hedi.model.Agence;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {

}
