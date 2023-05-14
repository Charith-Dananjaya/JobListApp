package dev.charith.JobListApp.service;


import dev.charith.JobListApp.model.Job;
import dev.charith.JobListApp.model.JobDTO;


import java.util.List;

public interface JobService {

    List<JobDTO> getJobs();

    JobDTO getJobById(long jobId);

    List<JobDTO> findByOwner(String owner);

    List<JobDTO> findByStatus();

    JobDTO findJobById(long id);

}
