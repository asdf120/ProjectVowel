package ex1_xml2_ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ex1_xml2/applicationContext.xml");

//        MemberBean memberBean = context.getBean("memberBean",MemberBean.class);
//        memberBean.setName("기묭관");
//        memberBean.output();
//
//        MemberBean memberBean2 = context.getBean("memberBean2",MemberBean.class);
//        memberBean2.output();

        MemberDao memberDao = context.getBean("memberDao", MemberDao.class);
        memberDao.insert();

        MemberDao memberDao2 = context.getBean("memberDao2", MemberDao.class);
        memberDao2.insert();
    }
}
