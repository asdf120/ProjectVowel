package ex1_xml3_pvalue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("ex1_xml3/applicationContext.xml");

        MemberBean memberBean = context.getBean("memberBean", MemberBean.class);
        memberBean.output();

        MemberDao memberDao = context.getBean("memberDao", MemberDao.class);
        memberDao.insert();
    }
}
