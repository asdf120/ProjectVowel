package videoshop.model.vo;

public class CustomerVO {
    private String name;
    private String tel;
    private String extra_tel;
    private String address;
    private String email;

    public CustomerVO() {
    }

    public CustomerVO(String name, String tel, String address, String email) {
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.email = email;
    }

    public CustomerVO(String name, String tel, String address, String email, String extra_tel) {
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.email = email;
        this.extra_tel = extra_tel;
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

    public String getExtra_tel() {
        return extra_tel;
    }

    public void setExtra_tel(String extra_tel) {
        this.extra_tel = extra_tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
