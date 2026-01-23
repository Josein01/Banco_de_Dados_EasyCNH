package com.example.demo.QuizResult;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/API/quizresults")
public class QuizResultController {
    private final QuizResultService quizResultService;
    @Autowired
    public QuizResultController(QuizResultService quizResultService) {
        this.quizResultService = quizResultService;
    }
    @GetMapping
    public List<QuizResult> getQuizResults() {
        return quizResultService.getQuizResults();
    }

}
