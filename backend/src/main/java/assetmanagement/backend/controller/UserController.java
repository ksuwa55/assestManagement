package assetmanagement.backend.controller;

import assetmanagement.backend.model.User;
import assetmanagement.backend.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username is already taken!");
        }

        // TODO: Add password hashing

        userRepository.save(user);
        return ResponseEntity.ok("User registered successfuly!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        Optional<User> foundUser = userRepository.findByUsername(user.getUsername());

        if (foundUser.isPresent()){
            // TODO: Add password comparison

            return ResponseEntity.ok("User logged in successfully!");
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password!");
        }
    }
}
