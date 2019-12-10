package com.esprit.habib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.habib.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
