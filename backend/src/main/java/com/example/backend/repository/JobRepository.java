package com.example.backend.repository;

import com.example.backend.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {
    @Query(value="select * from jobs where consultant_id=?1 and specialization=?2 and country=?3",nativeQuery = true)
    List<Job> findJobs(String consultant, String specialization, String country);
}
