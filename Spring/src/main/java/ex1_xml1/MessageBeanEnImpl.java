package ex1_xml1;

public class MessageBeanEnImpl implements MessageBean {

    public MessageBeanEnImpl() {
        System.out.println("MessageBeanEnImpl() 생성");
    }

    @Override
    public void sayHello(String name) {
        System.out.println(name + ", Good morning");
    }
}
