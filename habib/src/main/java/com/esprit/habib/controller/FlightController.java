package com.esprit.habib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.esprit.habib.exception.ResourceNotFoundException;
import com.esprit.habib.model.Flight;
import com.esprit.habib.repository.FlightRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/futuro")
public class FlightController {

	@Autowired
	FlightRepository flightRepository;
	
	// Get All Flights
	@GetMapping("/flights")
    public List<Flight> getAllFlights() {
		return flightRepository.findAll();
	}

    // Create a new Flight
    @PostMapping("/flights")
    public Flight createFlight(@Valid @RequestBody Flight flight) {
        return flightRepository.save(flight);
    }

    // Get a Single Flight
    @GetMapping("/flights/{id}")
    public Flight getFlightById(@PathVariable(value = "id") Long flighId) {
        return flightRepository.findById(flighId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    // Update a Flight
    @PutMapping("/flights/{id}")
    public Flight updateFlight(@PathVariable(value = "id") Long flighId,
                                            @Valid @RequestBody Flight flighDetails) {

    	Flight flight = flightRepository.findById(flighId)
        		.orElseThrow(() -> new ResourceNotFoundException("not found"));

    	flight.setTypeFlight(flighDetails.getTypeFlight());
    	flight.setAirCompany(flighDetails.getAirCompany());
    	flight.setDepart(flighDetails.getDepart());
    	flight.setDestination(flighDetails.getDestination());
    	flight.setNbPassenger(flighDetails.getNbPassenger());
    	flight.setPrice(flighDetails.getPrice());
    	flight.getService().setFlight(flight);

    	Flight updatedFlight = flightRepository.save(flight);
        return updatedFlight;
    }

    // Delete a Flight
    @DeleteMapping("/flights/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable(value = "id") Long flightId) {
    	Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

    	flightRepository.delete(flight);

        return ResponseEntity.ok().build();
    }
    
}
