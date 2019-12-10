package com.esprit.habib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.habib.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

}
