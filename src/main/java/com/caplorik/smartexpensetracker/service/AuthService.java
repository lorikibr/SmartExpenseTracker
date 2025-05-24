/*package com.caplorik.smartexpensetracker.service;

import com.caplorik.smartexpensetracker.model.User;
import com.caplorik.smartexpensetracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Register a new user
    public User registerUser(String username, String password) {
        // Check if user already exists
        Optional<User> existingUser = userRepository.findByUsername(username);
        if (existingUser.isPresent()) {
            throw new RuntimeException("Username already taken");
        }

        // Create new user and set password (no hashing for simplicity)
        User user = new User();
        user.setUsername(username);
        user.setPassword(password); // Storing plain text for now
        return userRepository.save(user); // Save the user in the database
    }

    // Authenticate user
    public boolean authenticate(String username, String password) {
        // Find user by username
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Compare password directly (plain text comparison)
            return user.getPassword().equals(password);
        }
        return false; // User not found
    }
}
*/