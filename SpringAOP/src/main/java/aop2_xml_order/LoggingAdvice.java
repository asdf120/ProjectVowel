package aop2_xml_order;

import org.aspectj.lang.ProceedingJoinPoint;


public class LoggingAdvice {

    public Object around(ProceedingJoinPoint joinpoint)throws Throwable{
        String methodName = joinpoint.getSignature().getName();
        System.out.println("[****************LoggingAdvice 사전작업] : " + methodName);
        Object object = joinpoint.proceed();
        System.out.println("[****************LoggingAdvice 사후작업] : " + methodName);

        return object;
    }

}
