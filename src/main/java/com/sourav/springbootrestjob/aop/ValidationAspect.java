package com.sourav.springbootrestjob.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import static org.slf4j.LoggerFactory.getLogger;
import org.slf4j.Logger;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = getLogger(ValidationAspect.class);

    @Around("execution(* com.sourav.springbootrestjob.Service.JobService.getJob(..)) && args(postId)") // (&& args(postId) it is for validating the id which is passed in the getJob()method arguments to get it)
    public Object validateAndUpdate(ProceedingJoinPoint jp , int postId) throws Throwable {

        if(postId<0){
            LOGGER.info("Post id is negative , updating it...");
            postId = -postId;
            LOGGER.info("New value for PostId is :"+ postId);
        }


        Object obj = jp.proceed(new Object[]{postId});

        return obj;
    }

}
