package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/start.do")
    public ModelAndView test(){
        System.out.println("start 요청");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello"); // view 지정
        // hello -> /WEB-INF/view/ + hello + .jsp
        mv.addObject("message", "오늘 점심 뭐 먹");
        return mv;
    }


}
