package controller;

import model.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ParamController {

    @RequestMapping("/param.do")
    public String param(String cate, String kind){
        System.out.println(cate);

        return "paramView";
    }

    // login.do 요청시 파라미터 지정
    @RequestMapping("/login.do")
    public String login(UserVO userVO, HttpSession httpSession){
        System.out.println(userVO.getId());
        System.out.println(userVO.getPassword());

        // DB의 회원테이블 값이라 가정
        String dbId = "kyg";
        String dbpass = "1234";

        /**
         * 세션이 필요할 때 HttpSession httpSession을 매개변수에 지정
         */
        if (userVO.getId().equals(dbId) && userVO.getPassword().equals(dbpass)) {
            // 세션에 로그인 정보 저장
            httpSession.setAttribute("userId", userVO.getId());
        }


        return "loginView";
    }

}
