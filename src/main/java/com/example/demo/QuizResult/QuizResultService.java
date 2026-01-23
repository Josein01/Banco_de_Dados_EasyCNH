package com.example.demo.QuizResult;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class QuizResultService {
    private final QuizResultRepository quizResultRepository;

    public QuizResultService(QuizResultRepository quizResultRepository) {
        this.quizResultRepository = quizResultRepository;
    }
    public List<QuizResult> getQuizResults() {
        return quizResultRepository.findAll();
    }

}
