package aop4_annotation.order;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * AOP(Aspect Oriented Program) : 관점 지향 프로그램
 */
public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("aop4_xml/applicationContext.xml");
		MemberService service = context.getBean("targetBean", MemberService.class);
		service.register();
		service.update("홍길동");
		
	}

	
}
