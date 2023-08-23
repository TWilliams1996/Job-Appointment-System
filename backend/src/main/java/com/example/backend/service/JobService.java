package com.example.backend.service;

import com.example.backend.entity.Job;
import com.example.backend.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public List<Job> getJobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs;
    }

    public List<Job> findJobs(String consultant, String specialization, String country){
        System.out.println("consultant: " + consultant + " specialization: " + specialization + " country: " + country);
        List<Job> jobs = jobRepository.findJobs(consultant, specialization, country);
        System.out.println(jobs);
        return jobs;
    }
}
