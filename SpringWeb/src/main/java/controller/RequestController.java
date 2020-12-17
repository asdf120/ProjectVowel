package controller;

import model.MemberService;
import model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@Controller
@RequestMapping("/board")
public class RequestController {

    //TODO javax.mail.internet 패키지를 못찾음
    @Autowired
    JavaMailSender mailSender;
    MemberService memberService;

    @RequestMapping("/request.do")
    public String request(MemberVO memberVO, HttpServletResponse response) throws IOException {
        System.out.println("/request.do 요청");

        // 난수 생성 알아볼것
        int random = new Random().nextInt(4589362) + 49311; // 난수

        System.out.println("RequestController 30Line Random : " + random);
        System.out.println("이메일 : " + memberVO.getId());

        String sender = "sssw0101@gmail.com";
        String receiver = memberVO.getId();
        String title = "이메일 인증";
        String content = "메일 확인 인증번호는 " + random + "입니다.";

        try{
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,true,"utf-8");

            messageHelper.setFrom(sender); // 보내는사람 생략하면 정상작동을 안함
            messageHelper.setTo(receiver); // 받는사람 이메일
            messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
            messageHelper.setText(content); // 메일 내용

            mailSender.send(message);
            System.out.println("메일 전송 완료");
        }catch (Exception e){
            System.out.println("이메일 전송 에러  : " + e.toString());
        }

        response.setContentType("text/html; charset=utf-8");
        PrintWriter out_email = response.getWriter();
        out_email.flush();

        return "board/request";
    }

    /**
     * 함수의 리턴형이 void 인 경우
     * --> 뷰페이지가 자동으로 지정
     * ex) request.do 요청 -> request
     *
     * ex) mapTest.do 요청 -> mapTest
     */
    @RequestMapping(value = "/request.do", method = RequestMethod.POST)
    public void request(MemberVO memberVO){
        System.out.println("/request.do 요청");
        System.out.println("이름 : " + memberVO.getName());
    }

    @RequestMapping(value = "/c.do", params = {"id=kim"})
    public void reqeustC(){
        System.out.println("c.do 요청");
    }
}
