package dev.charith.JobListApp.utility;

import dev.charith.JobListApp.model.Job;
import dev.charith.JobListApp.model.JobDTO;


//Util class to convert Job objects to jobDTO
public class DTOConverterUtil {

    public static JobDTO convertToDTO(Job job) {

        //Creating a new jobDTO
        JobDTO jobDTO = new JobDTO();

        //Formatting dates & time
        String startTime = DateTimeUtil.formatToLocalTime(job.getStartTime());
        String endTime = DateTimeUtil.formatToLocalTime(job.getEndTime());
        String queuedTime = DateTimeUtil.convertTimestamp(job.getQueuedTime());
        String duration = DateTimeUtil.formatMiliSeconds(job.getDuration());

        //Setting formatted values to the DTO
        jobDTO.setId(job.getId());
        jobDTO.setStartTime(startTime);
        jobDTO.setEndTime(endTime);
        jobDTO.setQueuedTime(queuedTime);
        jobDTO.setJobStatus(job.getJobStatus());
        jobDTO.setName(job.getName());
        jobDTO.setOwner(job.getOwner());
        jobDTO.setDuration(duration);

        return jobDTO;
    }

}
