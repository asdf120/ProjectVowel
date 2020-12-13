package ex2_annotation;

import org.springframework.stereotype.Component;

@Component
public class MemberBean {
    private String name;
    private int age;
    private String message;

    public MemberBean() {
        name="X맨";
        age=20;
        message="마가 낀 5강의실";
        System.out.println("MemberBean() 기본생성자");
    }

    public MemberBean(String name, int age, String message) {
        this.name = name;
        this.age = age;
        this.message = message;
        System.out.println("MemberBean() 인자생성자");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void output(){
        System.out.println(name + " [ " + age +" ] " + message);
    }
}
