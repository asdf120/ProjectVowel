package ex1_xml4_list;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ex1_xml4/applicationContext.xml");

        ListBean listBean = context.getBean("listBean", ListBean.class);
        for(int i : listBean.getIntegerList()){
            System.out.println(i);
        }

        for(MemberBean m : listBean.getMemberBeanList()) {
            m.output();
        }
    }
}
