package com.esprit.hedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.esprit.hedi.exception.ResourceNotFoundException;
import com.esprit.hedi.model.Agence;
import com.esprit.hedi.repository.AgenceRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/futuro")
public class AgenceController {
	
	@Autowired
	AgenceRepository agenceRepository;
	
	// Get All Agences
	@GetMapping("/getAgence")
	public List<Agence> getAllAgences() {
		return agenceRepository.findAll();
	}
	
	// Create a new Agence
    @PostMapping("/addAgence")
    public Agence createAgence(@Valid @RequestBody Agence agence) {
        return agenceRepository.save(agence);
    }

    // Get a Single Agence
    @GetMapping("/getAgence/{id}")
    public Agence getAgenceById(@PathVariable(value = "id") Long agenceId) {
        return agenceRepository.findById(agenceId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }
    
    
    // Update a Agence
    @PutMapping("/updateAgence/{id}")
    public Agence updateAgence(@PathVariable(value = "id") Long id_agence,
                                            @Valid @RequestBody Agence agenceDetails) {

    	Agence agence = agenceRepository.findById(id_agence)
        		.orElseThrow(() -> new ResourceNotFoundException("not found"));

    	agence.setNom(agenceDetails.getNom());
    	agence.setPays(agenceDetails.getPays());
    	agence.setRegion(agenceDetails.getRegion());
    	agence.setAdresse(agenceDetails.getAdresse());
    	agence.setNb_voitures(agenceDetails.getNb_voitures());
    	agence.setTel(agenceDetails.getTel());
    	agence.setDescription(agenceDetails.getDescription());
    	agence.setEmail(agenceDetails.getEmail());
    	agence.setType(agenceDetails.getType());

    	Agence updatedAgence= agenceRepository.save(agence);
        return updatedAgence;
    }
    
    // Delete a Agence
    @DeleteMapping("/deleteAgence/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long agenceId) {
    	Agence agence = agenceRepository.findById(agenceId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

    	agenceRepository.delete(agence);

        return ResponseEntity.ok().build();
    }
	
	

}
