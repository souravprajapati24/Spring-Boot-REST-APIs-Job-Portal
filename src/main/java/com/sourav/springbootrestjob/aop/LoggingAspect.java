package com.sourav.springbootrestjob.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import static org.slf4j.LoggerFactory.getLogger;

@Component
@Aspect // made this class as the aspect module
public class LoggingAspect {

    private static final Logger LOGGER = getLogger(LoggingAspect.class);

    // to advice a specific method so for that specify its  - return type ,fullyClassifiedClassName.MethodName.(Arguments)


    // logging aspect for all the methods before execution (@before is advice , expression inside () is pointcut )
//    @Before("execution(* com.sourav.springbootrestjob.Service.JobService.*(..))") // 1st * - class name , 2nd* - method name, 3 *(arguments . . dots for all the arguments )
//    public void logMethodCall(){
//        LOGGER.info("Method called");
//    }

    @Before("execution(* com.sourav.springbootrestjob.Service.JobService.getAllJobs(..)) || execution(* com.sourav.springbootrestjob.Service.JobService.getJob(..))") // we can define multiple methods in the point cut expression using ||
    public void logMethodCall(JoinPoint jp){  // join point is applied in the method execution to get hold on it
        LOGGER.info("Method called " + jp.getSignature().getName());
    }

    @After("execution(* com.sourav.springbootrestjob.Service.JobService.getAllJobs(..)) || execution(* com.sourav.springbootrestjob.Service.JobService.getJob(..))") // this advice will run after the method is executed
    public void logMethodExecuted(JoinPoint jp){  // join point is applied in the method execution to get hold on it
        LOGGER.info("Method executed " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.sourav.springbootrestjob.Service.JobService.getAllJobs(..)) || execution(* com.sourav.springbootrestjob.Service.JobService.getJob(..))") // this advice will if there is any exception in method
    public void logMethodException(JoinPoint jp){  // join point is applied in the method execution to get hold on it
        LOGGER.info("Method has some issues " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.sourav.springbootrestjob.Service.JobService.getAllJobs(..)) || execution(* com.sourav.springbootrestjob.Service.JobService.getJob(..))") // this advice will run after method has returned some value
    public void logMethodExecutedSuccess(JoinPoint jp){  // join point is applied in the method execution to get hold on it
        LOGGER.info("Method executed successfully " + jp.getSignature().getName());
    }

}
