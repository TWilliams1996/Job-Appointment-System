package com.example.backend.service;

import com.example.backend.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private EmailSenderService emailSenderService;

    public void pay(PaymentDTO paymentDTO){
        emailSenderService.sendEmail(paymentDTO.getEmail(), "Payment for JobList", "Your appointment is successfully placed in JobList....");
    }
}
