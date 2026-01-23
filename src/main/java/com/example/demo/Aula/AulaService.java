package com.example.demo.Aula;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AulaService {
    private final AulaRepository aulaRepository;
    public AulaService(AulaRepository aulaRepository) {
        this.aulaRepository = aulaRepository;
    }
    public List<Aula> getAulas() {
        return aulaRepository.findAll();
    }

}
