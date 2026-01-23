package com.example.demo.SupportTicket;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SupportTicketService {
    private final SupportTicketRepository supportTicketRepository;
    public SupportTicketService(SupportTicketRepository supportTicketRepository) {
        this.supportTicketRepository = supportTicketRepository;
    }
    public List<SupportTicket> getSupportTickets() {
        return supportTicketRepository.findAll();
    }
}   
