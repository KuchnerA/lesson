package ru.learnUp.feb.learnupjava20.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProcessorAspect {


    private static final Logger log = LoggerFactory.getLogger(ProcessorAspect.class);


    @Pointcut("execution(* ru.learnUp.feb.learnupjava20.service.processors.*.*(..))")
    public void callInProcessorsPath() {
    }

    @Before("callInProcessorsPath()")
    public void beforCall(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.info("arg: {}", arg);
        }
        Object target = joinPoint.getTarget();
        Object thiss = joinPoint.getThis();
        log.info("{}", target);
        log.info("{}", thiss);
    }

    @Around("callInProcessorsPath()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Before execute {}", joinPoint.toString());
        Object result = joinPoint.proceed();
        log.info("After execute {}", joinPoint.toString());
        return result;
    }

    @Before("@annotation(ru.learnUp.feb.learnupjava20.service.Calculable)")
    public void beforeAnnotation(JoinPoint joinPoint) {
        log.info("Calculating! {}", joinPoint);
    }

}
