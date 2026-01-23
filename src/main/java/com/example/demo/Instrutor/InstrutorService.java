package com.example.demo.Instrutor;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class InstrutorService {
    private final InstrutorRepository instructorRepository;
    public InstrutorService(InstrutorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }
public List<Instrutor> getInstrutores() {
    return instructorRepository.findAll();

}
}