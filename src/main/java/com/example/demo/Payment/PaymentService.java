package com.example.demo.Payment;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }
}
