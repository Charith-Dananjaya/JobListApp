package dev.charith.JobListApp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JobDTO {

    private long id;
    private String startTime;
    private String endTime;
    private String queuedTime;
    private String jobStatus;
    private String name;
    private String owner;
    private String duration;



}

