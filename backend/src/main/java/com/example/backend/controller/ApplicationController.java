package com.example.backend.controller;

import com.example.backend.dto.ApplicationDTO;
import com.example.backend.entity.Consultant;
import com.example.backend.entity.Job;
import com.example.backend.entity.JobSeeker;
import com.example.backend.repository.ApplicationRepository;
import com.example.backend.repository.ConsultantRepository;
import com.example.backend.repository.JobRepository;
import com.example.backend.repository.JobSeekerRepository;
import com.example.backend.service.ApplicationService;
import com.example.backend.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@CrossOrigin
public class ApplicationController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ConsultantRepository consultantRepository;

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private JobSeekerService jobSeekerService;

    @GetMapping("/")
    public String home() {
        Consultant consultant1 = new Consultant();
        consultant1.setName("John");
        consultant1.setCountry("Sri Lanka");

        Consultant consultant2 = new Consultant();
        consultant2.setName("Rick");
        consultant2.setCountry("UK");

        Consultant consultant3 = new Consultant();
        consultant3.setName("Hale");
        consultant3.setCountry("USA");

        consultantRepository.save(consultant1);
        consultantRepository.save(consultant2);
        consultantRepository.save(consultant3);


        Job job1 = new Job();
        job1.setTitle("manager");
        job1.setDescription("manage works of the office");
        job1.setConsultant(consultant1);
        job1.setCountry("Sri Lanka");
        job1.setSpecialization("Financial");

        Job job2 = new Job();
        job2.setTitle("tech lead");
        job2.setDescription("lead software engineers");
        job2.setConsultant(consultant2);
        job2.setCountry("USA");
        job2.setSpecialization("Software");

        Job job3 = new Job();
        job3.setTitle("intern software engineer");
        job3.setDescription("intern react spring boot full stack development");
        job3.setConsultant(consultant2);
        job3.setCountry("USA");
        job3.setSpecialization("Software");

        Job job4 = new Job();
        job4.setTitle("maths teacher");
        job4.setDescription("maths teacher for primary school");
        job4.setConsultant(consultant3);
        job4.setCountry("UK");
        job4.setSpecialization("Education");

        jobRepository.save(job1);
        jobRepository.save(job2);
        jobRepository.save(job3);
        jobRepository.save(job4);


//        JobSeeker jobSeeker = new JobSeeker();
//        jobSeeker.setName("Trever");
//        jobSeeker.setDob(LocalDate.of(2000,01,02));
//        jobSeeker.setEmail("trever@gmail.com");
//        jobSeeker.setBirthCountry("Sri Lanka");
//        jobSeeker.setCv("cv.pdf");
//        jobSeekerRepository.save(jobSeeker);

//        Application application = new Application();
//        application.setJob(job);
//        application.setJobSeeker(jobSeeker);
//        applicationRepository.save(application);
        return "Welcome!";
    }

    @PostMapping(path = "/apply", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public String apply(@ModelAttribute ApplicationDTO applicationDTO) throws IOException {
        System.out.println(applicationDTO.getName());
        JobSeeker jobSeeker = jobSeekerService.saveJobSeeker(applicationDTO);
        applicationService.saveApplication(jobRepository.findById(Long.parseLong(applicationDTO.getJobId())).get(), jobSeeker, applicationDTO.getAppointmentDate());
        return "Application saved successfully";
    }
}
