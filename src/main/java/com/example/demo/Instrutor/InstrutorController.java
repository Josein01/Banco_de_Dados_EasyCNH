package com.example.demo.Instrutor;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/API/instrutores")
public class InstrutorController {
    private final InstrutorService instrutorService;
    @Autowired
    public InstrutorController(InstrutorService instrutorService) {
        this.instrutorService = instrutorService;
    }
    @GetMapping
    public List<Instrutor> getInstrutores() {
        return instrutorService.getInstrutores();
    }

}
