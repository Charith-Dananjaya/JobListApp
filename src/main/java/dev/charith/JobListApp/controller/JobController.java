package dev.charith.JobListApp.controller;


import dev.charith.JobListApp.model.Job;
import dev.charith.JobListApp.model.JobDTO;
import dev.charith.JobListApp.service.JobService;
import dev.charith.JobListApp.service.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import java.util.List;

//Controller class to handle Job requests
@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobService jobService;

    //Controller method to handle requests to retrieve a list of all jobs
    @GetMapping("/list")
    public String getAllJobs(Model theModel) throws IOException {

        // Get the list of job DTOs from service layer
        List<JobDTO> jobDTOList = jobService.getJobs();

        // Add the list of jobDTO to the view model
        theModel.addAttribute("jobs", jobDTOList);

        // Return name of the view to render
        return "job-list";

    }

    //Controller method to handle expand job requests
    @GetMapping("/expand")
    public String getAJob(@RequestParam("jobId") long jobId, Model theModel) throws IOException {

        //Get the jobDTO from service layer
        JobDTO jobDTO = jobService.getJobById(jobId);

        //Add the jobDTO to the view model
        theModel.addAttribute("job", jobDTO);

        //Return name of the view to render
        return "job-list-expand";

    }

    //Controller method to handle searchByOwnerName requests
    @GetMapping("/searchByOwner")
    public String getJobs(@RequestParam("owner") String owner, Model model) {

        //Get the list of jobDTOs related to the owner from service layer
        List<JobDTO> jobs = jobService.findByOwner(owner);

        //Add the list of jobDTOs to the view model
        model.addAttribute("jobs", jobs);

        //Return name of the view to render
        return "job-list";

    }

    //Controller method to handle list requests
    @GetMapping("/searchByStatus")
    public String getJobsByStatus(@RequestParam("status") String status, Model model) {

        //Get the list of jobDTOs based on status
        List<JobDTO> jobs = jobService.findByStatus();

        //Add the list of jobDTOs to the view model
        model.addAttribute("jobs", jobs);

        //Return name of the view to render
        return "job-list";

    }


    //Controller method to handle searchById requests
    @GetMapping("/searchById")
    public String getJobById(@RequestParam("jobId") String id, Model model) {
        if(id == null || id.isEmpty()){
            return "job-list";
        }

        //Get the jobDTO based on id
        JobDTO job = jobService.findJobById(Long.parseLong(id));

        //Add jobDTO to the view model
        model.addAttribute("jobs", job);

        //Return name of the view to render
        return "job-list";

    }


}
