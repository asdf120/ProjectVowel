package aop2_xml_order;

import org.aspectj.lang.JoinPoint;

public class LogginSample {
    public void before(JoinPoint joinpoint) throws Throwable{
        String methodName = joinpoint.getSignature().getName();
        System.out.println("[****************LoggingSample 사전작업] : " + methodName);
    }

    public void after(JoinPoint joinpoint) throws Throwable{
        String methodName = joinpoint.getSignature().getName();
        System.out.println("[****************LoggingSample 사후작업] : " + methodName);
    }
}
