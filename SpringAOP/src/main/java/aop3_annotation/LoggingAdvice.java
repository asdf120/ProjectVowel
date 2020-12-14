package aop3_annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {

    @Around("execution(public * aop3_annotation.*.*Hello(..))")
    public Object around(ProceedingJoinPoint joinpoint)throws Throwable{
        String methodName = joinpoint.getSignature().getName();
        System.out.println("[**************** 사전작업] : " + methodName);
        Object object = joinpoint.proceed();
        System.out.println("[**************** 사후작업] : " + methodName);

        return object;
    }

//    @Before("execution(public * aop3_annotation.*.*Hello())")
    public void before(JoinPoint joinpoint) throws Throwable{
        String methodName = joinpoint.getSignature().getName();

        System.out.println("[**************** 사전작업] : " + methodName);
    }
}
