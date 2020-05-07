package com.nick.spring.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

    @Pointcut("execution(* com.nick.spring.aop.data.*.*(..))")
    public void dataLayerExecution() { }

    @Pointcut("execution(* com.nick.spring.aop.business.*.*(..))")
    public void businessLayerExecution() { }

    @Pointcut(
            "com.nick.spring.aop.aspect.CommonJoinPointConfig.dataLayerExecution() && com.nick.spring.aop.aspect.CommonJoinPointConfig.businessLayerExecution()"
    )
    public void allLayerExecution(){ }

    @Pointcut("bean(*dao*)") // all method calls on beans containing dao in the name are matched by pointcut
    public void beanStartingWithDao(){ }

    @Pointcut("@annotation(com.nick.spring.aop.aspect.TrackTime)")
    public void trackTimeAnnotation(){}
}
