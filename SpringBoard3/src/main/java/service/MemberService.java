package service;


import domain.MemberVO;

public interface MemberService {
	public MemberVO idCheck_Login(MemberVO vo);
	public int userInsert(MemberVO vo);

}
