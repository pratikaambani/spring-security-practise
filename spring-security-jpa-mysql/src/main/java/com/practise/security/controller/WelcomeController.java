package com.practise.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String sayHello() {
        return ("<h1>Hiiiiiiiiiiiiiiiiiiiii All</h1>");
    }

    @GetMapping("/admin")
    public String sayHelloAdmin() {
        return ("<h1>Hiiiiiiiiiiiiiiiiiiiii Admin</h1>");
    }

    @GetMapping("/user")
    public String sayHelloUser() {
        return ("<h1>Hiiiiiiiiiiiiiiiiiiiii User</h1>");
    }

}
