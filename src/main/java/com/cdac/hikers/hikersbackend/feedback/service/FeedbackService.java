package com.cdac.hikers.hikersbackend.feedback.service;

import com.cdac.hikers.hikersbackend.feedback.entities.FeedbackEntities;
import com.cdac.hikers.hikersbackend.feedback.repository.FeedbackRepository;
import com.cdac.hikers.hikersbackend.util.userValidation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository repository;

    @Autowired
    private UserValidation userValidation;

    public String addFeedbackData(FeedbackEntities feedbackEntities) {

        try {
            if (userValidation.checkForRegisteredUser(feedbackEntities.getName(), feedbackEntities.getEmail())) {
                repository.save(feedbackEntities);
                return "Feedback added!!";
            } else {
                return "please check Name and Email, it should be same as you entered in Signup.";
            }
        } catch (Exception ex) {
            return "Error occured while submit feedback";
        }
    }

    public List<FeedbackEntities> getAllFeedback() {
        return repository.findAll();
    }
}
