package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import model.MemberVO;
import model.MemberVOList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController {



    @PostMapping("/multiInsert.do")
    public ModelAndView test(MemberVOList memberVOList){
        System.out.println("multiInsert.do 요청");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("multiInsert");
        // TODO 체크에 따라서 화면띄워주기
        for(MemberVO member : memberVOList.getMemberList()){
            if (member.isState()) {
                mv.addObject("member",member);
            }
        }
//        for(int i = 0; i<memberVOList.getMemberList().size(); i++){
//            if(memberVOList.getMemberList().get(i).isState()){
//                mv.addObject("member", memberVOList.getMemberList().get(i));
//            }
//        }
        return mv;
    }

}
