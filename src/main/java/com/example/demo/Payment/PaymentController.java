package com.example.demo.Payment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/API/pagamentos")
public class PaymentController {
    private final PaymentService paymentService;
    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @GetMapping
    public List<Payment> getPayments() {
        return paymentService.getPayments();
    }   

}
