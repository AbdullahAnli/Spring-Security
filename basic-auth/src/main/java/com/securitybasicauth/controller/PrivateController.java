package com.securitybasicauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class PrivateController {
    @GetMapping
    public String helloPublic(){
        return "hello Laz Umut";
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String helloUser(){
        return "user";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String helloadmin(){
        return  "admin";
    }
}
