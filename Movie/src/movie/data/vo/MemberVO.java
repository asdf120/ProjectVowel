package movie.data.vo;

public class MemberVO {
    private String member_id;  // 회원아이디
    private String password;    // 비번
    private String tel;         // 전번
    private String name;        // 이름
    private String birth;       // 생년월일
    private String email;       // 이메일

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
