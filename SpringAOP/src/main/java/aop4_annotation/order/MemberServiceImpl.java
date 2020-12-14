package aop4_annotation.order;

import org.springframework.stereotype.Component;

@Component("targetBean")
public class MemberServiceImpl implements MemberService {

	@Override
	public void register() {
		System.out.println("register 함수 호출");
	}

	@Override
	public boolean update(String memberId) {
		System.out.println("update 함수 호출 : " + memberId);
		return true;
	}
}
