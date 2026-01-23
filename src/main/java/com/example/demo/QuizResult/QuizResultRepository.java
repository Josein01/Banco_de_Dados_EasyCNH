package com.example.demo.QuizResult;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizResultRepository extends JpaRepository<QuizResult, Long> {

}
