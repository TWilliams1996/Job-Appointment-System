package com.example.backend.service;

import com.example.backend.entity.Consultant;
import com.example.backend.repository.ConsultantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ConsultantService {

    @Autowired
    private ConsultantRepository consultantRepository;

    public List<Consultant> getConsultants() {
        List<Consultant> consultants = consultantRepository.findAll();
        return consultants;
    }

}
