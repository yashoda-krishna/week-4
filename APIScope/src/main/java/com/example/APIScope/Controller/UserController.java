package com.example.APIScope.Controller;

import com.example.APIScope.Model.User;
import com.example.APIScope.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;


    // Functional scope: register
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userService.existsByUsername(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(user));
    }


    // Security scope: only ADMIN can see all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    // Data scope: ADMIN can view anyone; USER can view only own
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id, Authentication authentication) {
        var loggedIn = userService.findByUsername(authentication.getName())
                .orElseThrow(() -> new RuntimeException("Logged-in user not found"));


        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));


        if (isAdmin) {
            return ResponseEntity.ok(userService.getUserById(id));
        } else if (loggedIn.getId().equals(id)) {
            return ResponseEntity.ok(loggedIn);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Access denied: you can only view your own profile.");
        }
    }
}