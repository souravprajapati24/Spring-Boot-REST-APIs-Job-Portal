package com.sourav.springbootrestjob.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import static org.slf4j.LoggerFactory.getLogger;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {

    private static final Logger LOGGER = getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.sourav.springbootrestjob.Service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis(); //  before statement for the proceding join point

        Object obj = jp.proceed(); // this is here for the procedding join point which is actuall the method  for which we are calculating the time
        // jp.proceed return the object for the request


        long end = System.currentTimeMillis();  // after statement for the proceding join point

        LOGGER.info("Time taken by "+ jp.getSignature().getName() + " "  + (end-start) + " ms");
        return obj;  // @Around advice return a obj so its important to return an obje using the objevt class
    }

}
