package aop4_annotation.order;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
 * AOP
 * 2. annotation  이용
 */

// @Aspect , @Order(), 각 메소드 별 어노테이션

@Component
@Aspect
@Order(2)
public class LoggingAdvice {

    @Around("execution(public * aop4_annotation.*.*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        String methodName = point.getSignature().getName();
        System.out.println("[사전작업] : " + methodName);
        Object obj = point.proceed();
        System.out.println("[사후작업] : " + methodName);
        return obj;
    }
}
