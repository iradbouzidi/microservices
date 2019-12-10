package com.esprit.habib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.habib.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

}
