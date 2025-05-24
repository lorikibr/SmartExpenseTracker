/*package com.caplorik.smartexpensetracker.controller;

import com.caplorik.smartexpensetracker.model.User;
import com.caplorik.smartexpensetracker.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000") // Adjust if needed
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody User user) {
        try {
            User registeredUser = authService.registerUser(user.getUsername(), user.getPassword());
            return ResponseEntity.status(201).body(new ApiResponse("User " + registeredUser.getUsername() + " registered successfully!"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(new ApiResponse(e.getMessage()));
        }
    }

    // Login a user and create a session
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User user, HttpSession session) {
        boolean isAuthenticated = authService.authenticate(user.getUsername(), user.getPassword());
        if (isAuthenticated) {
            session.setAttribute("username", user.getUsername());  // Store the username in session
            return ResponseEntity.ok(new ApiResponse("Login successful!"));
        } else {
            return ResponseEntity.status(401).body(new ApiResponse("Invalid username or password"));
        }
    }

    // Logout the user and invalidate the session
    @PostMapping("/logout")
    public ResponseEntity<Object> logout(HttpSession session) {
        session.invalidate();  // Invalidate the session
        return ResponseEntity.ok(new ApiResponse("Logout successful!"));
    }

    // Helper class for uniform JSON response format
    public static class ApiResponse {
        private String message;

        public ApiResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
*/