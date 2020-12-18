package controller;

import domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.MemberService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/{url}.do")
    public String test(@PathVariable String url){
        System.out.println(url + "요청");
        return "/user/"+url;
    }

    @RequestMapping("/userInsert.do")
    public String  userInsert(MemberVO memberVO,Model model){

        int result = memberService.userInsert(memberVO);
        String message = memberVO.getUserName() + "님 죄송합니다";
        if(result>0){
            message = memberVO.getUserName() + "님 회원가입 축하";
        }
        model.addAttribute("message",message);

        System.out.println("회원가입 완료");
        return "user/userJoin_ok"; // 저 저 파일이없어용 파일은없어도ㅓ댐 뭐여이거왜먹통
    }

    @RequestMapping("/login.do")
    public String login(MemberVO memberVO, HttpSession session){
        MemberVO member = memberService.idCheck_Login(memberVO);
        System.out.println(memberVO.getUserId());
        if (member == null || member.getUserId() == null) {
            return "user/userLogin";
        }else{
            session.setAttribute("login", member.getUserName());

            return "user/login_ok";
        }

    }

    /**
     *
     */
    @RequestMapping(value = "/idCheck.do", produces = "application/text;charset=utf-8")
    @ResponseBody // AJAX 처리를 해주는 어노테이션
    public String idCheck(MemberVO memberVO){
        MemberVO member = memberService.idCheck_Login(memberVO);
        String message ="";
        if (member == null || member.getUserId() == null) {
            message = "사용가능한 아이디";
        }else{
            message = "이미 사용중인 아이디";
        }
        /**
         * 추후에는 보내는 데이터는 JSON 구조로 만들고
         * 그 json을 문자열로 변환해서 리턴
         * *********** 리턴형이 String ==> viewPage 지정
         * AJAX인 경우는 결과 리턴
         */
        return message;

    }
}
