package com.example.backend.controller;

import com.example.backend.entity.Consultant;
import com.example.backend.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ConsultantController {

    @Autowired
    private ConsultantService consultantService;

    @GetMapping("/getConsultants")
    public List<Consultant> getConsultants() {
        List<Consultant> consultants = consultantService.getConsultants();
        return consultants;
    }
}
