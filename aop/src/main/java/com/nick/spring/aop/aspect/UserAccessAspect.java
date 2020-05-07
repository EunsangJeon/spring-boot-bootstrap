package com.nick.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// AOP
// Configuration
@Aspect // Pointcut + Advice = Aspect
@Configuration
public class UserAccessAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // What kind of method calls I would intercept and when
    @Before("com.nick.spring.aop.aspect.CommonJoinPointConfig.dataLayerExecution()") // Pointcut
    public void before(JoinPoint joinPoint) {
        // Advice
        logger.info("Intercepted Method Calls - {}", joinPoint);
    }

}
