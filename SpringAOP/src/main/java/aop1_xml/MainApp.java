package aop1_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop1_xml/applicationContext.xml");

        MessageBean messageBean = context.getBean("targetBean", MessageBean.class);
        messageBean.sayHello();
        System.out.println("---------------------------------------");
        messageBean.engSayHello();
        System.out.println("---------------------------------------");
        messageBean.test();
    }
}
