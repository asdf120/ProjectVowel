package aop2_xml_order;

public class MemberServiceImpl implements MemberService {

    @Override
    public void register() {
        System.out.println("회원가입 되었습니다");
    }

    @Override
    public boolean update(String memberId) {
        System.out.println(memberId + "님 정보가 수정되었습니다.");
        return true;
    }
}
