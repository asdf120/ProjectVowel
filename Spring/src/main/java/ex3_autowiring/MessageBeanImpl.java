package ex3_autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class MessageBeanImpl implements MessageBean {

    private String name;
    private String message;

//    @Autowired
//    @Qualifier("outputer2")
    @Resource(name = "outputer2")
    private Outputer outputer;

    // setter or 생성자 중에 하나로 지정

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayHello() {
        System.out.println(name + "님께 " + message);

        try{
            outputer.writeMessage(name + "님께 " + message);
        }catch (Exception e){
            System.out.println("MessageBeanImpl 오류 : " + e.toString());
        }
    }
}
