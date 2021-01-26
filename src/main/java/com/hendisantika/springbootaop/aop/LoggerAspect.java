package com.hendisantika.springbootaop.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

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

}
