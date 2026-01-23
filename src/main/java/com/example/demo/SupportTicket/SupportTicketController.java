package com.example.demo.SupportTicket;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/API/support-tickets")
public class SupportTicketController {
    private final SupportTicketService supportTicketService;
    @Autowired
    public SupportTicketController(SupportTicketService supportTicketService) {
        this.supportTicketService = supportTicketService;
    }
@GetMapping
public List<SupportTicket> getSupportTickets() {
    return supportTicketService.getSupportTickets();
}
}
