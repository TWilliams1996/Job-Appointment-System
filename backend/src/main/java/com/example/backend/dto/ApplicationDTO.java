package com.example.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApplicationDTO {
    private String jobId;
    private String name;
    private LocalDate dob;
    private String email;
    private String country;
    private MultipartFile cv;
    private LocalDate appointmentDate;
}
