package dev.charith.JobListApp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Job {

    private long id;
    private String startTime;
    private String endTime;
    private String queuedTime;
    private String jobStatus;
    private String jobFolderPath;
    private String path;
    private String customer;
    private String name;
    private String owner;
    private List<Label> labels;
    private long duration;

}






