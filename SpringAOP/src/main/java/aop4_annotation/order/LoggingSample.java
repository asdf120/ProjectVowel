package aop4_annotation.order;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
 * AOP 
 * 2. annotation  이용
 */

// @Aspect , @Order(), 각 메소드 별 어노테이션

@Component
@Aspect
@Order(1)
public class LoggingSample {

	@Before("execution(public * aop4_annotation.order.*.*(..))")
	public void before(JoinPoint p){
		System.out.println("before : 메소드 호출 전" + p );
	}

	@After("execution(public * aop4_annotation.order.*.*(..))")
	public void after(JoinPoint p){
		System.out.println("afterReturning : 메소드 호출 된 후에 예외 발생이 없는 경우 " + p );
	}
	

}
