package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ReturnController {

    /**
     * 뷰페이지명 지정
     * 1. ModelAndView 이용
     * 2. void 리턴형 -> 자동지정
     * 3. String 리턴형 -> 뷰페이지명 리턴
     */

    /**
     *  컨트롤러에서 뷰단으로 데이터 전달 방식
     *  1. ModelAndView 리턴
     *  2. Map 리턴 ( ex. HashMap )
     *  3. Model 이용
     */

    @RequestMapping("/map.do")
    public String map(){
        System.out.println("map.do 요청");
        Map map = new HashMap<>();
        map.put("message", "오늘도 에러 안나길 바라며");
        map.put("id", "홍길동");

        System.out.println(map.get("id"));
        return "mapView";
    }

    @RequestMapping("/model.do")
    public String model(Model m){
        System.out.println("model.do 요청");

        m.addAttribute("message", "3조 화이팅");
        m.addAttribute("name","기묭관");

        return "modelView";
    }
}
