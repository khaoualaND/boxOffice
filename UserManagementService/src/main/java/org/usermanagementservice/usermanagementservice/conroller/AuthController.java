package org.usermanagementservice.usermanagementservice.conroller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.usermanagementservice.usermanagementservice.enumeration.RoleName;
import org.usermanagementservice.usermanagementservice.model.Customer;
import org.usermanagementservice.usermanagementservice.security.JwtUtil;
import org.usermanagementservice.usermanagementservice.service.CustomerService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    private final CustomerService userService;
    private final JwtUtil jwtUtil;

    public AuthController(CustomerService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Customer customer, @RequestParam RoleName roleName) {
        userService.registerUser(customer, roleName);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        // Authenticate (use Spring Security for this)
        // Generate JWT
        String token = jwtUtil.generateToken(authRequest.getUsername());
        return ResponseEntity.ok(token);
    }
}

@Data
class AuthRequest {
    private String username;
    private String password;
}
