package com.cdac.hikers.hikersbackend.util.userValidation;

import com.cdac.hikers.hikersbackend.signup.entities.SignupEntities;
import com.cdac.hikers.hikersbackend.signup.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidation {

    @Autowired
    private SignupRepository signupRepository;

    public Boolean checkForRegisteredUser(String name, String email) {
        try {
//            SignupEntities signupEntities = signupRepository.findByNameAndEmail(name.trim(), email.trim());
//            System.out.println("checking user : ");
//            System.out.println(signupEntities);
//            if (signupEntities != null && signupEntities.getName().equalsIgnoreCase(name) && signupEntities.getEmail().equalsIgnoreCase(email)) {
//                System.out.println("booking name : "+ name+", signup name : "+signupEntities.getName());
//                System.out.println("booking email : "+ email+", signup email : "+signupEntities.getEmail());
//                return true;
//            } else {
//                return false;
//            }
            return signupRepository.existsByNameAndEmail(name, email);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
