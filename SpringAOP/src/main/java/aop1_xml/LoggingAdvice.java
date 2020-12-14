package aop1_xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


public class LoggingAdvice {

    public Object around(ProceedingJoinPoint joinpoint)throws Throwable{
        String methodName = joinpoint.getSignature().getName();
        System.out.println("[**************** 사전작업] : " + methodName);
        Object object = joinpoint.proceed();
        System.out.println("[**************** 사후작업] : " + methodName);

        return object;
    }

    public void before(JoinPoint joinpoint) throws Throwable{
        String methodName = joinpoint.getSignature().getName();

        System.out.println("[**************** 사전작업] : " + methodName);
    }
}
