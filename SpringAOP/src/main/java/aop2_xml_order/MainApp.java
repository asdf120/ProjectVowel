package aop2_xml_order;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop2_xml/applicationContext.xml");

        MemberService memberService = context.getBean("targetBean",MemberService.class);

        memberService.register();
        System.out.println("======================================");
        memberService.update("홍길동");
    }
}
