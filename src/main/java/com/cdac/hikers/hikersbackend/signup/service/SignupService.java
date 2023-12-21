package com.cdac.hikers.hikersbackend.signup.service;

import com.cdac.hikers.hikersbackend.signup.entities.SignupEntities;
import com.cdac.hikers.hikersbackend.signup.repository.SignupRepository;
import com.cdac.hikers.hikersbackend.util.email.service.EmailService;
import com.cdac.hikers.hikersbackend.util.userValidation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignupService {
    @Autowired
    //private SignupBean bean;
    private SignupRepository repository;
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserValidation userValidation;

    public String addSignupData(SignupEntities signupEntities) {
        try {
            repository.save(signupEntities);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error occuring while inserting data!";
        }
        return "Signup data added.";
    }

    public List<SignupEntities> getAllSignupData() {
        return repository.findAll();
    }
}
