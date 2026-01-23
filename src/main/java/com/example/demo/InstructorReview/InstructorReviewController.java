package com.example.demo.InstructorReview;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/API/InstructorReview")
public class InstructorReviewController {
    private final InstructorReviewService instructorReviewService;
    @Autowired
    public InstructorReviewController(InstructorReviewService instructorReviewService) {
        this.instructorReviewService = instructorReviewService;
    }
    @GetMapping
    public List<InstructorReview> getInstructorReviews() {
        return instructorReviewService.getInstructorReviews();
    }

}
