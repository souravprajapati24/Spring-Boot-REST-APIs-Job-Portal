package com.sourav.springbootrestjob.Service;

import com.sourav.springbootrestjob.Repository.JobRepo;
import com.sourav.springbootrestjob.Model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost){
      repo.save(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }

    public JobPost getJob(int postId){
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost){
        repo.save(jobPost);
    }

    public void deleteJob(int postId){
       repo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(
                        1,
                        "Java Backend Developer",
                        "Develop REST APIs and backend services using Spring Boot",
                        2,
                        List.of("Java", "Spring Boot", "Hibernate", "MySQL")
                ),

                new JobPost(
                        2,
                        "Full Stack Developer",
                        "Work on both frontend and backend web applications",
                        3,
                        List.of("Java", "Spring Boot", "React", "JavaScript", "PostgreSQL")
                ),

                new JobPost(
                        3,
                        "Software Engineer",
                        "Design scalable applications and write clean code",
                        1,
                        List.of("Java", "OOP", "Data Structures", "Git")
                ),

                new JobPost(
                        4,
                        "Backend Developer",
                        "Build and maintain microservices-based systems",
                        4,
                        List.of("Java", "Spring Boot", "Microservices", "Docker", "Kafka")
                ),

                new JobPost(
                        5,
                        "Junior Java Developer",
                        "Assist in backend development and bug fixing",
                        0,
                        List.of("Java", "Spring", "JDBC", "MySQL")
                )
        ));

        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword , keyword);
    }

    public List<JobPost> serachByExperience(int exp) {
        return repo.findByReqExperience(exp);
    }
}
