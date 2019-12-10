package com.esprit.irad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.esprit.irad.exception.ResourceNotFoundException;
import com.esprit.irad.model.User;
import com.esprit.irad.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/futuro")
public class UserController {
	
	@Autowired
    UserRepository userRepository;
	
	// Get All Users
	@GetMapping("/users")
    public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
    // Create a new User
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
    	user.getProfile().setUser(user);
        return userRepository.save(user);
    }

    // Get a Single User
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    // Update a User
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable(value = "id") Long userId,
                                            @Valid @RequestBody User userDetails) {

        User user = userRepository.findById(userId)
        		.orElseThrow(() -> new ResourceNotFoundException("not found"));

        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.getProfile().setUser(user);

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    // Delete a User
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }

}
