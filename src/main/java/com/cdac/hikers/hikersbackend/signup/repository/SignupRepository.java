package com.cdac.hikers.hikersbackend.signup.repository;

import com.cdac.hikers.hikersbackend.signup.entities.SignupEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupRepository extends JpaRepository<SignupEntities, Integer> {

    Boolean existsByNameAndEmail(String name, String email);

    SignupEntities findByNameAndEmail(String name, String email);
}
