package com.example.demo.Quiz;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class QuizService {
    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    } public List<Quiz> getQuizzes() {
        return quizRepository.findAll();
    }

}
