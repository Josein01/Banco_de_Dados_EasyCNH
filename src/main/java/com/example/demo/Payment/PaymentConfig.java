package com.example.demo.Payment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {
    @Bean
    CommandLineRunner commandLineRunnerPayment(PaymentRepository paymentRepository) {
        return args -> {
        };
    }
}
