package rw.vladvisionlab.inzozi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.vladvisionlab.inzozi.dtos.AuthenticationRequest;
import rw.vladvisionlab.inzozi.dtos.AuthenticationResponse;
import rw.vladvisionlab.inzozi.dtos.RegisterRequest;
import rw.vladvisionlab.inzozi.services.AuthenticationService;

@RestController
@RequestMapping("/security")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationService authenticationService;
    
    @PostMapping("/user/create")
    public ResponseEntity<String> createAccount(@RequestBody RegisterRequest request) {
        authenticationService.register(request);
        return ResponseEntity.ok("Account created successfully");
    }
    
    @PostMapping("/user/authenticate")
    public AuthenticationResponse verifyCredentials(
            @RequestBody AuthenticationRequest request
    ) {
        return authenticationService.authenticate(request);
    }
}
