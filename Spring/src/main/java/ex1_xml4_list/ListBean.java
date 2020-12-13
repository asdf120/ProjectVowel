package ex1_xml4_list;

import java.util.List;

public class ListBean {
    private List<Integer> integerList;
    private List<MemberBean> memberBeanList;

    public ListBean() {
    }

    public ListBean(List<Integer> integerList) {
        this.integerList = integerList;
    }



    public List<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public List<MemberBean> getMemberBeanList() {
        return memberBeanList;
    }

    public void setMemberBeanList(List<MemberBean> memberBeanList) {
        this.memberBeanList = memberBeanList;
    }
}
