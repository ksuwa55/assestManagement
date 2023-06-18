package assetmanagement.backend.controller;

import assetmanagement.backend.repository.UserRepository;
import assetmanagement.backend.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public void signup(@RequestBody User user) {
        // Check if the username already exists
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new RuntimeException("Username already exists");
        }

        // Save the new user
        userRepository.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        } else {
            return ResponseEntity.ok("User logged in successfully!");
        }
    }
}
