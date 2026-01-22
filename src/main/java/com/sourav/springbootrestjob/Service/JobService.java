package com.sourav.springbootrestjob.Service;

import com.sourav.springbootrestjob.Repository.JobRepo;
import com.sourav.springbootrestjob.Model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;
    @Autowired
    private JobPost jobPost;

    public void addJob(JobPost jobPost){
      repo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repo.getAllJobs();
    }

    public JobPost getJob(int postId){
        return repo.getJob(postId);
    }

    public void updateJob(JobPost jobPost){
        repo.updateJob(jobPost);
    }

    public boolean deleteJob(int postId){
       return repo.deleteJob(postId);
    }

}
