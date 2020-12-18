package contoller;


import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/test.do")
    public String test(){
        System.out.println("확인");

        return "test";
    }
}
