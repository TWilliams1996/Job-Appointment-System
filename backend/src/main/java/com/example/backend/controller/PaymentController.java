package com.example.backend.controller;

import com.example.backend.dto.PaymentDTO;
import com.example.backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(path = "/pay", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public String apply(@ModelAttribute PaymentDTO paymentDTO){
        paymentService.pay(paymentDTO);
        return "Payment is successful";
    }
}
