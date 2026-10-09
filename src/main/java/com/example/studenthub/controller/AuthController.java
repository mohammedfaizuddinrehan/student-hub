package com.example.studenthub.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(
        origins = "http://localhost:63342",
        allowCredentials = "true"
)
public class AuthController {

    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public String login(
            @RequestBody LoginRequest request,
            HttpServletRequest httpRequest
    ) {

        try {

            Authentication authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.email(),
                                    request.password()
                            )
                    );

            SecurityContext securityContext =
                    SecurityContextHolder.createEmptyContext();

            securityContext.setAuthentication(authentication);

            SecurityContextHolder.setContext(securityContext);

            HttpSessionSecurityContextRepository repository =
                    new HttpSessionSecurityContextRepository();

            repository.saveContext(
                    securityContext,
                    httpRequest,
                    null
            );

            System.out.println("AUTHENTICATION SUCCESS");

            return "Login successful";

        } catch (Exception e) {

            e.printStackTrace();

            return "Login failed: " + e.getMessage();
        }
    }

    @GetMapping("/me")
    public String currentUser(Authentication authentication) {

        System.out.println("Authentication: " + authentication);

        if (authentication == null) {
            return "No authenticated user";
        }

        System.out.println(
                "Authenticated: " + authentication.isAuthenticated()
        );

        return authentication.getName();
    }

    public record LoginRequest(
            String email,
            String password
    ) {
    }
}