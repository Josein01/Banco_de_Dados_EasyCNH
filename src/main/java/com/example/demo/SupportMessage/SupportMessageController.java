package com.example.demo.SupportMessage;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/API/supportMessages")
public class SupportMessageController {
    private final SupportMessageService supportMessageService;
    @Autowired
    public SupportMessageController(SupportMessageService supportMessageService) {
        this.supportMessageService = supportMessageService;
    }
    @GetMapping
    public List<SupportMessage> getSupportMessages() {
        return supportMessageService.getSupportMessages();
    }
}
