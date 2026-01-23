package com.example.demo.Candidate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }
    public List<Candidate> getCandidates() {
        return candidateRepository.findAll();
    }

}
