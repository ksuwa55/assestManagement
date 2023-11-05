package assetmanagement.backend.controller;

import assetmanagement.backend.repository.UserRepository;
import assetmanagement.backend.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class UserController {
    private final UserRepository userRepository;

    @Value("${app.jwtSecret}") // Read the secret key from configuration (e.g., application.properties)
    private String jwtSecret;

    @Value("${app.jwtExpirationMs}") // Read the token expiration time from configuration (e.g., application.properties)
    private int jwtExpirationMs;

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
            throw new RuntimeException("something happened");
        } else {
            // Generate JWT token
            String token = generateJwtToken(existingUser);

            // Return the token in the request body
            return ResponseEntity.ok(token);
        }
    }

    @GetMapping("/getuserinfo")
    public Map<Long, String> getUserInfo(@RequestParam String username, @RequestParam String password) {
        User existingUser = userRepository.findByUsername(username);

        if (existingUser != null && existingUser.getPassword().equals(password)) {
            Long id = existingUser.getId();
            Map<Long, String> userInfo = new HashMap<>();
            userInfo.put(id, username);
            return userInfo;
        }

        throw new RuntimeException("Invalid username or password");
    }

    private String generateJwtToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        // create the JWT token
        return Jwts.builder()
                .setSubject(Long.toString(user.getId()))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    // Helper method to validate and parse JWT token
    private Claims parseJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJwt(token)
                .getBody();
    }
}
