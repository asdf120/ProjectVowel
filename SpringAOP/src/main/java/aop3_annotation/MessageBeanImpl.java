package aop3_annotation;

import org.springframework.stereotype.Component;

@Component("targetBean")
public class MessageBeanImpl implements MessageBean {

    @Override
    public void sayHello() {
        System.out.println("sayHello() 호출");
    }

    @Override
    public void engSayHello() {
        System.out.println("engSayHello() 호출");
    }

    @Override
    public void test() {
        System.out.println("test() 호출");
    }
}
