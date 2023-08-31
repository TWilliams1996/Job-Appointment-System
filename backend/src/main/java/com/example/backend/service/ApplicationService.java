package com.example.backend.service;

import com.example.backend.dto.ApplicationDTO;
import com.example.backend.entity.Application;
import com.example.backend.entity.Job;
import com.example.backend.entity.JobSeeker;
import com.example.backend.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    public void saveApplication(Job job, JobSeeker jobSeeker, ApplicationDTO applicationDTO){
        Application application = new Application();
        application.setJob(job);
        application.setJobSeeker(jobSeeker);
        application.setAppointmentDate(applicationDTO.getAppointmentDate());
        applicationRepository.save(application);
        emailSenderService.sendEmail(applicationDTO.getEmail(), "Payment for JobList", "Your appointment is successfully placed in JobList....");
    }
}
