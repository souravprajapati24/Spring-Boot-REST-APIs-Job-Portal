package com.sourav.springbootrestjob.Repository;

import com.sourav.springbootrestjob.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

    @Query
    List<JobPost> findByPostProfileContainingIgnoreCaseOrPostDescContainingIgnoreCase(
            String postProfile, String postDesc);


    public List<JobPost> findByReqExperience(int exp);
}

//
//List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//        new JobPost(
//                1,
//                "Java Backend Developer",
//                "Develop REST APIs and backend services using Spring Boot",
//                2,
//                List.of("Java", "Spring Boot", "Hibernate", "MySQL")
//        ),
//
//        new JobPost(
//                2,
//                "Full Stack Developer",
//                "Work on both frontend and backend web applications",
//                3,
//                List.of("Java", "Spring Boot", "React", "JavaScript", "PostgreSQL")
//        ),
//
//        new JobPost(
//                3,
//                "Software Engineer",
//                "Design scalable applications and write clean code",
//                1,
//                List.of("Java", "OOP", "Data Structures", "Git")
//        ),
//
//        new JobPost(
//                4,
//                "Backend Developer",
//                "Build and maintain microservices-based systems",
//                4,
//                List.of("Java", "Spring Boot", "Microservices", "Docker", "Kafka")
//        ),
//
//        new JobPost(
//                5,
//                "Junior Java Developer",
//                "Assist in backend development and bug fixing",
//                0,
//                List.of("Java", "Spring", "JDBC", "MySQL")
//        )
//));
//public List<JobPost> getAllJobs(){
//    return jobs;
//}
//
//public void addJob(JobPost job){
//    jobs.add(job);
//    System.out.println(jobs);
//}
//
//public JobPost getJob(int postId){
//
//    for(JobPost job: jobs){
//        if(job.getPostID() == postId){
//            return job;
//        }
//    }
//
//    return null;
//}
//
//public void updateJob(JobPost jobPost){
//    for(JobPost jobPost1 : jobs){
//        if(jobPost.getPostID() == jobPost1.getPostID()){
//            jobPost1.setPostDesc(jobPost.getPostDesc());
//            jobPost1.setPostProfile(jobPost.getPostProfile());
//            jobPost1.setPostTechStack(jobPost.getPostTechStack());
//            jobPost1.setReqExperience(jobPost.getReqExperience());
//        }
//    }
//}
//
//public boolean deleteJob(int postId){
//    for (JobPost jobPost : jobs){
//        if(postId == jobPost.getPostID()){
//            return jobs.remove(jobPost);
//        }
//    }
//    return false;
//}
