package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/06")
public class RedirectController {

    @RequestMapping("/select.do")
    public String select(Model model){
        System.out.println("select.do 요청");
        model.addAttribute("info","추후 DB값");
        return "06/selectView";
    }

    @RequestMapping("/insert.do")
    public String insert(){
        System.out.println("insert.do 요청");

        // 입력 후에 목록보기 페이지 전환
        // return "selectView"; ==> 출력 페이지만 지정
        return "redirect:06/select.do";
    }

}
