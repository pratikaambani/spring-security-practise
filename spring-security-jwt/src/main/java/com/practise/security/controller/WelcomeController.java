package com.practise.security.controller;

import com.practise.security.api.AuthenticationRequest;
import com.practise.security.api.AuthenticationResponse;
import com.practise.security.services.MyUserDetailsService;
import com.practise.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @GetMapping("/")
    public String sayHello() {
        return ("<h1>Hiiiiiiiiiiiiiiiiiiiii All</h1>");
    }

    @GetMapping("/user")
    public String sayHelloUser() {
        return ("<h1>Hiiiiiiiiiiiiiiiiiiiii User</h1>");
    }

    @GetMapping("/admin")
    public String sayHelloAdmin() {
        return ("<h1>Hiiiiiiiiiiiiiiiiiiiii Admin</h1>");
    }

    @PostMapping("/authenticate")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest request) throws Exception {
        try {
            //authenticate
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        //generate JWT
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(request.getUsername());
        String jwt = JwtUtil.generateJwt(userDetails);
        System.out.println(jwt);
        return new AuthenticationResponse(jwt);
    }

}
