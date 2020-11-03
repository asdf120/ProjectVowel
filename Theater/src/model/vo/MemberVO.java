package src.model.vo;

public class MemberVO {
    private String member;
    private String password;
    private String tel;
    private String name;
    private String birth;
    private String email;

    public MemberVO() {
    }

    public MemberVO(String member, String password, String tel, String name, String birth, String email) {
        this.member = member;
        this.password = password;
        this.tel = tel;
        this.name = name;
        this.birth = birth;
        this.email = email;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
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
