package com.esprit.hedi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.hedi.model.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {

}
