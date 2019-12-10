package com.esprit.hedi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.hedi.exception.ResourceNotFoundException;
import com.esprit.hedi.model.Commande;
import com.esprit.hedi.repository.CommandeRepository;

@RestController
@RequestMapping("/futuro")
public class CommandeController {

	
	@Autowired
    CommandeRepository comRepository;
	
	// Get All Commandes
	@GetMapping("/getCommande")
    public List<Commande> getAllCommandes() {
		return comRepository.findAll();
	}
	
	// Create a new commandes
    @PostMapping("/addCommande")
    public Commande createCommande(@Valid @RequestBody Commande commande) {
        return comRepository.save(commande);
    }
    
    
    // Update a Commande
    @PutMapping("/updateCommande/{id_commande}")
    public Commande updateCommande(@PathVariable(value = "id_commande") int id_commande,
                                            @Valid @RequestBody Commande commandeDetails) {

        Commande commande = comRepository.findById(id_commande)
        		.orElseThrow(() -> new ResourceNotFoundException("not found"));

        commande.setType_service(commandeDetails.getType_service());
        commande.setNbr_personne(commandeDetails.getNbr_personne());
        commande.setPrix_personne(commandeDetails.getPrix_personne());
        commande.setTotale(commandeDetails.getTotale());
       
        Commande updatedCommande = comRepository.save(commande);
        return updatedCommande;
    }
    
    // Delete a commande
    @DeleteMapping("/deleteCommande/{id_commande}")
    public ResponseEntity<?> deleteCommande(@PathVariable(value = "id_commande") int id_commande) {
        Commande commande = comRepository.findById(id_commande)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        comRepository.delete(commande);

        return ResponseEntity.ok().build();
    }

}
