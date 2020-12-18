package controller;

import dao.TransferDAO;
import domain.ReceiverVO;
import domain.SenderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransferController {


	// 1. 스프링 MVC 만 확인
	@RequestMapping( value="{url}.do")
	public String url(@PathVariable String url)
	{
		System.out.println("요청");		
		return "/"+url;
	}

	//2.
	@Autowired
	TransferDAO dao;

	@RequestMapping(value="/transfer.do",method=RequestMethod.POST)
	public ModelAndView addAll(SenderVO send, ReceiverVO recv)  throws Exception{

		String msg = "계좌가 성공적으로 이체되었습니다.";
		dao.transfer(send, recv);
		ModelAndView ma = new ModelAndView("result");
		ma.addObject("msg",msg);
		return ma;
	}

}
