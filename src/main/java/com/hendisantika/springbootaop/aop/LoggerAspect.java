package com.hendisantika.springbootaop.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-aop
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/01/21
 * Time: 06.38
 */
@Configuration
@Aspect
@Log4j2
public class LoggerAspect {
    @Before("@annotation(MethodLogger)")
    public void beforeMethodStart(JoinPoint point) {
        log.info("Method " + point.getSignature().getName() + " Started at " + LocalDateTime.now());
    }

    @After("@annotation(MethodLogger)")
    public void afterMethodStart(JoinPoint point) {
        log.info("Method " + point.getSignature().getName() + " Ended at " + LocalDateTime.now());
    }

    @Around("@annotation(CalculatePerformance)")
    public void calculate(ProceedingJoinPoint point) {
        LocalTime startTime = LocalTime.now();
        try {
            point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            LocalTime endTime = LocalTime.now();
            log.info("Processing time of Method " + point.getSignature().getName() + " -> "
                    + SECONDS.between(startTime, endTime));
        }
    }

}
