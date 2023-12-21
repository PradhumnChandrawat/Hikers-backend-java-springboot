package com.cdac.hikers.hikersbackend.signup.controller;

import com.cdac.hikers.hikersbackend.signup.entities.SignupEntities;
import com.cdac.hikers.hikersbackend.signup.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SignupController {

    @Autowired
    private SignupService service;

    @PostMapping("/signup")
    public String postSignupData(@RequestBody SignupEntities signupEntities) {
        System.out.println("We are in post controller");
        System.out.println(signupEntities.getName());
        System.out.println(signupEntities.getDob());
        System.out.println(signupEntities.getEmail());
        System.out.println(signupEntities.getPhone());
        System.out.println(signupEntities.getPassword());
        System.out.println("saving signup entities.......");
        return service.addSignupData(signupEntities);
    }

    @GetMapping("/viewsignup")
    public List<SignupEntities> viewContact(SignupEntities signupEntities) {
        return service.getAllSignupData();
    }
}
