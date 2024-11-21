package event.SpringBootApp.services;

import event.SpringBootApp.Entities.userEntity;
import event.SpringBootApp.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private userRepository userRepository;

    // Register a new user
    public String registerUser(userEntity user) {
        // Check if the email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "Email already exists.";
        }

        // Save the new user with plain text password
        userRepository.save(user);
        return "User registered successfully";
    }

    // Authenticate user login
    public String loginUser(userEntity user) {
        // Find user by email
        Optional<userEntity> existingUserOptional = userRepository.findByEmail(user.getEmail());

        // Check if the user exists and passwords match
        if (existingUserOptional.isPresent()) {
            userEntity existingUser = existingUserOptional.get();
            if (existingUser.getPassword().equals(user.getPassword())) {
                // Include the user's role in the success message
                return "Login successful. Role: " + existingUser.getRole();
            }
        }
        return "Invalid email or password";
    }
}
