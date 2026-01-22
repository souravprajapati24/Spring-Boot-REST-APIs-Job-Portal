package com.sourav.springbootrestjob;


import com.sourav.springbootrestjob.Model.JobPost;
import com.sourav.springbootrestjob.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/") // this annotation is used to connect the url to the backend because its running on different server and its origin is different
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
//@ResponseBody --> it will return a response to the client (data)
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }


    @GetMapping("jobPost/{postId}")
    public JobPost getJOb(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }


    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){ // @RequestBody will store the body of the object (data) into the parameter (object)
        service.addJob(jobPost);

        return service.getJob(jobPost.getPostID());
    }


    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostID());
    }

    @DeleteMapping("jobPost/{postId}")
    public boolean deleteJob(@PathVariable int postId){
        return service.deleteJob(postId);
    }

}
