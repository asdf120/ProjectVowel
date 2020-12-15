package controller;

import model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AutoScanController {

    @Autowired
    private MemberVO memberVO;

    @RequestMapping("/autoScan.do")
    public ModelAndView autoScan(){
        System.out.println("autoScan.do 요청됨");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("autoScan"); //==> /WEB-INF/view/autoScan.jsp
        mv.addObject("memberVO", memberVO);
        return mv;
    }

}
