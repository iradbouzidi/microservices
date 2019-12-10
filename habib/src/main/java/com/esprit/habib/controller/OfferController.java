package com.esprit.habib.controller;

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

import com.esprit.habib.exception.ResourceNotFoundException;
import com.esprit.habib.model.Offer;
import com.esprit.habib.repository.OfferRepository;

@RestController
@RequestMapping("/futuro")
public class OfferController {
	
	@Autowired
	OfferRepository offerRepository;
	
	// Get All Offers
	@GetMapping("/offers")
    public List<Offer> getAllOffers() {
		return offerRepository.findAll();
	}

    // Create a new Offer
    @PostMapping("/offers")
    public Offer createOffer(@Valid @RequestBody Offer offer) {
        return offerRepository.save(offer);
    }

    // Get a Single Offer
    @GetMapping("/offers/{id}")
    public Offer getOfferById(@PathVariable(value = "id") Long offerId) {
        return offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }
    
    // Update a Offer
    @PutMapping("/offers/{id}")
    public Offer updateOffer(@PathVariable(value = "id") Long offerId,
                                            @Valid @RequestBody Offer offerDetails) {

    	Offer offer = offerRepository.findById(offerId)
        		.orElseThrow(() -> new ResourceNotFoundException("not found"));

    	offer.setTypeOffer(offerDetails.getTypeOffer());
    	offer.setPeriodOffer(offerDetails.getPeriodOffer());
    	offer.setDescription(offerDetails.getDescription());
    	offer.getService().setOffer(offer);
    	Offer updatedOffer = offerRepository.save(offer);
        return updatedOffer;
    }
    
    // Delete a Offer
    @DeleteMapping("/offers/{id}")
    public ResponseEntity<?> deleteOffer(@PathVariable(value = "id") Long offerId) {
    	Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

    	offerRepository.delete(offer);

        return ResponseEntity.ok().build();
    }


}
