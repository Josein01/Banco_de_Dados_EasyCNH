package com.example.demo.Aula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/API/aulas")
public class AulaController {
    private final AulaService aulaService;
    @Autowired
    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }
    @GetMapping
    public List<Aula> getAulas() {
        return aulaService.getAulas();
    }

}
