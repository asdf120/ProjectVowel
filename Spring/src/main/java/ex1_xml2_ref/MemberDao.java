package ex1_xml2_ref;

public class MemberDao {

    private MemberBean memberBean;

    public MemberDao() {

    }

    public MemberDao(MemberBean memberBean) {
        this.memberBean = memberBean;
    }

    public void setMemberBean(MemberBean memberBean) {
        this.memberBean = memberBean;
    }

    public void insert(){
        memberBean.output();
    }
}
