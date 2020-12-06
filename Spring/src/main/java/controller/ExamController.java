package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExamController {

    @RequestMapping(value = "/")
    public String test(){
        return "spring";
    }

    @RequestMapping(value = "/index")
    public String test2(){
        return "index";
    }
}
