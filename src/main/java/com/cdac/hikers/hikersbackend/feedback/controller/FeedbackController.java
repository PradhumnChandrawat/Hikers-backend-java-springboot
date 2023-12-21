package com.cdac.hikers.hikersbackend.feedback.controller;

import com.cdac.hikers.hikersbackend.feedback.entities.FeedbackEntities;
import com.cdac.hikers.hikersbackend.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class FeedbackController {
    @Autowired
    private FeedbackService service;

    @PostMapping("/submitfeedback")
    public String addUsersFeedbackData(@RequestBody FeedbackEntities feedbackEntities) {

        System.out.println("Add user method is working");
        return service.addFeedbackData(feedbackEntities);


    }

    //To get feedback data

    @GetMapping("/viewfeedback")
    public List<FeedbackEntities> getFeedbackData() {
        return service.getAllFeedback();
    }

}
