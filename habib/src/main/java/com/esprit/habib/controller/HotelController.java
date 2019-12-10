package com.esprit.habib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.esprit.habib.exception.ResourceNotFoundException;
import com.esprit.habib.model.Hotel;
import com.esprit.habib.repository.HotelRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/futuro")
public class HotelController {
	
	@Autowired
	HotelRepository hotelRepository;
	
	// Get All Hotels
	@GetMapping("/hotels")
    public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

    // Create a new Hotel
    @PostMapping("/hotels")
    public Hotel createHotel(@Valid @RequestBody Hotel hotel) {
        return hotelRepository.save(hotel);
    }
    /*
    @PostMapping("/services/{serviceId}/hotels")
    public Hotel createHotel(@PathVariable (value = "serviceId") Long serviceId,
                                 @Valid @RequestBody Hotel hotel) {
        return hotelRepository.findById(serviceId).map(service -> {
            hotel.setService(service);
            return hotelRepository.save(hotel);
        }).orElseThrow(() -> new ResourceNotFoundException("ServiceId " + serviceId + " not found"));
    }*/

    // Get a Single Hotel
    @GetMapping("/hotels/{id}")
    public Hotel getHotelById(@PathVariable(value = "id") Long hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }
    
    // Update a Hotel
    @PutMapping("/hotels/{id}")
    public Hotel updateHotel(@PathVariable(value = "id") Long hotelId,
                                            @Valid @RequestBody Hotel hotelDetails) {

    	Hotel hotel = hotelRepository.findById(hotelId)
        		.orElseThrow(() -> new ResourceNotFoundException("not found"));

    	hotel.setTypeHotel(hotelDetails.getTypeHotel());
    	hotel.setAddress(hotelDetails.getAddress());
    	hotel.setNbResident(hotelDetails.getNbResident());
    	hotel.setNbRoom(hotelDetails.getNbRoom());
    	hotel.setNbStars(hotelDetails.getNbStars());
    	hotel.setDescription(hotelDetails.getDescription());
    	hotel.getService().setHotel(hotel);

    	Hotel updatedHotel = hotelRepository.save(hotel);
        return updatedHotel;
    }

    
    // Delete a Flight
    @DeleteMapping("/hotels/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable(value = "id") Long hotelId) {
    	Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

    	hotelRepository.delete(hotel);

        return ResponseEntity.ok().build();
    }
    
}
