package com.esprit.habib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.esprit.habib.exception.ResourceNotFoundException;
import com.esprit.habib.model.Service;
import com.esprit.habib.repository.ServiceRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/futuro")
public class ServiceController {
	
	@Autowired
	ServiceRepository serviceRepository;
	
	// Get All Services
	@GetMapping("/services")
    public List<Service> getAllServices() {
		return serviceRepository.findAll();
	}

    // Create a new Service
    @PostMapping("/services")
    public Service createService(@Valid @RequestBody Service service) {
    	service.getOffer().setService(service);
    	service.getHotel().setService(service);
    	service.getFlight().setService(service);
        return serviceRepository.save(service);
    }

    // Get a Single Service
    @GetMapping("/services/{id}")
    public Service getServiceById(@PathVariable(value = "id") Long serviceId) {
        return serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }
    
    // Update a User
    @PutMapping("/services/{id}")
    public Service updateService(@PathVariable(value = "id") Long serviceId,
                                            @Valid @RequestBody Service ServiceDetails) {

    	Service service = serviceRepository.findById(serviceId)
        		.orElseThrow(() -> new ResourceNotFoundException("not found"));

    	service.setDescription(ServiceDetails.getDescription());
    	
    	/*
    	 * KAMMEL LES CHAMPS LOKHRIN
    	 */
    	
        Service updatedService = serviceRepository.save(service);
        return updatedService;
    }
    
    // Delete a Service
    @DeleteMapping("/services/{id}")
    public ResponseEntity<?> deleteService(@PathVariable(value = "id") Long serviceId) {
    	Service service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

    	serviceRepository.delete(service);

        return ResponseEntity.ok().build();
    }


}
