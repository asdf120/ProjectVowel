package ex2_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDAO {

    // 3 필드기반의 의존성 주입 방식
    @Autowired
    private MemberBean memberBean;

//    public MemberDao() {
//    }

//    public MemberDao(MemberBean memberBean) {
//        this.memberBean = memberBean;
//    }

//    public void setMemberBean(MemberBean memberBean) {
//        this.memberBean = memberBean;
//    }

    public void insert(){
        memberBean.output();
    }
}
