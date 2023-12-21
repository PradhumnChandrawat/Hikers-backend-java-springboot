package com.cdac.hikers.hikersbackend.feedback.repository;

import com.cdac.hikers.hikersbackend.feedback.entities.FeedbackEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackEntities, Integer> {

}
