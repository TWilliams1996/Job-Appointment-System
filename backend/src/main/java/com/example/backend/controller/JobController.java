package com.example.backend.controller;

import com.example.backend.entity.Job;
import com.example.backend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/getJobs")
    public List<Job> getConsultants() {
        List<Job> jobs = jobService.getJobs();
        return jobs;
    }

    @PostMapping("/findJobs")
    public List<Job> findJobs(@RequestParam(name = "consultant") String consultant,
                         @RequestParam(name = "specialization") String specialization,
                         @RequestParam(name = "country") String country) {
        List<Job> jobs = jobService.findJobs(consultant, specialization, country);
        return jobs;
    }
}

