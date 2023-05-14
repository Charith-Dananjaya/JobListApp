package dev.charith.JobListApp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.charith.JobListApp.model.Job;
import dev.charith.JobListApp.model.JobDTO;
import dev.charith.JobListApp.utility.DTOConverterUtil;

import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs;
    private int a = 1;

    public JobServiceImpl() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        jobs = objectMapper.readValue(getClass().getClassLoader().getResourceAsStream("data/JobjsonFile.json"),
                new TypeReference<List<Job>>() {
                });

    }

    //Method to get list of jobDTO
    public List<JobDTO> getJobs() {

        List<JobDTO> jobDTOs = new ArrayList<>();
        for (Job job : jobs) {
            jobDTOs.add(DTOConverterUtil.convertToDTO(job));
        }
        return jobDTOs;
    }

    //Method to get jobDTO by id
    public JobDTO getJobById(long jobId) {

        for (Job job : jobs) {
            if (job.getId() == jobId) {
                return DTOConverterUtil.convertToDTO(job);
            }
        }
        return null;
    }

    //Method to find all jobs by owner
    public List<JobDTO> findByOwner(String owner) {

        List<JobDTO> jobsBasedOnOwner = new ArrayList<>();
        for (Job job : jobs) {
            if (job.getOwner().toLowerCase(Locale.ROOT).contains(owner.toLowerCase(Locale.ROOT))) {
                jobsBasedOnOwner.add(DTOConverterUtil.convertToDTO(job));
            }
        }
        return jobsBasedOnOwner;

    }

    // Method to toggle and find all jobs by status and return a list of jobs
    public List<JobDTO> findByStatus() {

        List<JobDTO> jobsBasedOnStatus = new ArrayList<>();

        if (a % 2 == 0) {
            for (Job job : jobs) {
                if (job.getJobStatus().contains("Completed")) {
                    jobsBasedOnStatus.add(DTOConverterUtil.convertToDTO(job));
                }
            }
        } else {
            for (Job job : jobs) {
                if (job.getJobStatus().contains("Failed")) {
                    jobsBasedOnStatus.add(DTOConverterUtil.convertToDTO(job));
                }
            }
        }
        a++;
        return jobsBasedOnStatus;

    }

    // Method to find a job by ID and return a jobDTO
    public JobDTO findJobById(long id) {

        for (Job job : jobs) {
            if (job.getId() == id) {
                return DTOConverterUtil.convertToDTO(job);
            }
        }
        return null;

    }
}

