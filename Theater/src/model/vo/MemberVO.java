package src.model.vo;

public class MemberVO {
    private String member_id;  // 회원아이디
    private String password;
    private String tel;
    private String name;
    private String birth;
    private String email;

    public MemberVO() {
    }

    public MemberVO(String member, String password, String tel, String name, String birth, String email) {
        this.member_id = member;
        this.password = password;
        this.tel = tel;
        this.name = name;
        this.birth = birth;
        this.email = email;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
