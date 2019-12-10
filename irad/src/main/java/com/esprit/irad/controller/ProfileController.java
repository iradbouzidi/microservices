package com.esprit.irad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.esprit.irad.exception.ResourceNotFoundException;
import com.esprit.irad.model.Profile;
import com.esprit.irad.repository.ProfileRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/futuro")
public class ProfileController {
	
	@Autowired
	ProfileRepository profileRepository;
	
	// Get All Profiles
	@GetMapping("/profiles")
    public List<Profile> getAllProfiles() {
		return profileRepository.findAll();
	}

    // Create a new Profile
    @PostMapping("/profiles")
    public Profile createProfile(@Valid @RequestBody Profile profile) {
        return profileRepository.save(profile);
    }

    // Get a Single User
    @GetMapping("/profiles/{id}")
    public Profile getProfileById(@PathVariable(value = "id") Long profileId) {
        return profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    // Update a User
    @PutMapping("/profiles/{id}")
    public Profile updateProfile(@PathVariable(value = "id") Long profileId,
                                            @Valid @RequestBody Profile profileDetails) {

    	Profile profile = profileRepository.findById(profileId)
        		.orElseThrow(() -> new ResourceNotFoundException("not found"));

    	profile.setPhoneNumber(profileDetails.getPhoneNumber());
    	//profile.setGender(profileDetails.getGender());
    	//profile.setDateOfBirth(profileDetails.getDateOfBirth());
    	profile.setAddress1(profileDetails.getAddress1());
    	//profile.setAddress2(profileDetails.getAddress2());
    	//profile.setStreet(profileDetails.getStreet());
    	//profile.setCity(profileDetails.getCity());
    	//profile.setState(profileDetails.getState());
    	profile.setCountry(profileDetails.getCountry());
    	//profile.setZipCode(profileDetails.getZipCode());
    	profile.setUser(profileDetails.getUser());

    	Profile updatedProfile = profileRepository.save(profile);
        return updatedProfile;
    }

    // Delete a User
    @DeleteMapping("/profiles/{id}")
    public ResponseEntity<?> deleteProfile(@PathVariable(value = "id") Long profileId) {
    	Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        profileRepository.delete(profile);

        return ResponseEntity.ok().build();
    }

}
