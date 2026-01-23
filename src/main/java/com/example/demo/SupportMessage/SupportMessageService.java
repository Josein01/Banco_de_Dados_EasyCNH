package com.example.demo.SupportMessage;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SupportMessageService {
    private final SupportMessageRepository supportMessageRepository;
    public SupportMessageService(SupportMessageRepository supportMessageRepository) {
        this.supportMessageRepository = supportMessageRepository;
    }
    public List<SupportMessage> getSupportMessages() {
        return supportMessageRepository.findAll();
    }
}
