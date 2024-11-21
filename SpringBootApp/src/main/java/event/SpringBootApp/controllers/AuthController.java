package event.SpringBootApp.controllers;

import event.SpringBootApp.Entities.userEntity;
import event.SpringBootApp.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private userRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody userEntity user) {
        Map<String, String> response = new HashMap<>();

        // Check if the email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            response.put("message", "Email already exists.");
            return ResponseEntity.badRequest().body(response);
        }

        // Save the new user
        userRepository.save(user);
        response.put("message", "User registered successfully");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody userEntity user) {
        Map<String, String> response = new HashMap<>();

        // Validate input
        if (user.getEmail() == null || user.getPassword() == null) {
            response.put("message", "Email and password must be provided.");
            return ResponseEntity.badRequest().body(response);
        }

        // Find user by email
        Optional<userEntity> existingUserOptional = userRepository.findByEmail(user.getEmail());

        // Check if the user exists and passwords match
        if (existingUserOptional.isPresent()) {
            userEntity existingUser = existingUserOptional.get();
            if (existingUser.getPassword().equals(user.getPassword())) {
                response.put("message", "Login successful");
                response.put("role", String.valueOf(existingUser.getRole()));
                return ResponseEntity.ok(response);
            }
        }

        response.put("message", "Invalid email or password");
        return ResponseEntity.badRequest().body(response);
    }
}
