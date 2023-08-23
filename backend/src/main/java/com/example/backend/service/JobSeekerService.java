package com.example.backend.service;

import com.example.backend.dto.ApplicationDTO;
import com.example.backend.entity.JobSeeker;
import com.example.backend.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

@Service
@Transactional
public class JobSeekerService {
    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public JobSeeker saveJobSeeker(ApplicationDTO applicationDTO) throws IOException {
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setName(applicationDTO.getName());
        jobSeeker.setEmail(applicationDTO.getEmail());
        jobSeeker.setDob(applicationDTO.getDob());
        jobSeeker.setBirthCountry(applicationDTO.getCountry());

        MultipartFile cv = applicationDTO.getCv();
        String fileName = cv.getOriginalFilename();
        Random random = new Random();
        int randomNumber = random.nextInt(100000000);
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        Files.copy(cv.getInputStream(), Path.of("C:\\cv\\" + randomNumber + "." + extension));

        jobSeeker.setCv("C:\\cv\\" + randomNumber + "." + extension);
        return jobSeekerRepository.save(jobSeeker);
    }
}
