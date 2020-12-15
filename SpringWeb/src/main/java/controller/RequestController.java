package controller;

import model.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class RequestController {

    @RequestMapping("/request.do")
    public String request(MemberVO memberVO){
        System.out.println("/request.do 요청");
        return "board/request";
    }

//    @RequestMapping("/request.do")
//    public void request(MemberVO memberVO){
//        System.out.println("/request.do 요청");
//    }
    /**
     * 함수의 리턴형이 void 인 경우
     * --> 뷰페이지가 자동으로 지정
     * ex) request.do 요청 -> request
     *
     * ex) mapTest.do 요청 -> mapTest
     */
}
