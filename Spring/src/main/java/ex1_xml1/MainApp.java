package ex1_xml1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        // 0. POJO - 기존 자바 형식
//        MessageBean bean = new MessageBeanEnImpl();
//        bean.sayHello("hong");
//
//        MessageBean bean2 = new MessageBeanKoImpl();
//        bean2.sayHello("기묭관");

        // 1. DI
        System.out.println("MainApp 17Line : " + "시작");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("MainApp 20Line : " + "시작2222");

        MessageBean messageBean = (MessageBean)applicationContext.getBean("beanKo");
        messageBean.sayHello("kyg");

        MessageBean messageBean2 = (MessageBean)applicationContext.getBean("beanKo");
        messageBean2.sayHello("기묭관");

        MessageBean messageBean3 = (MessageBean)applicationContext.getBean("beanEn", MessageBean.class);
        messageBean3.sayHello("hong");


    }
}
