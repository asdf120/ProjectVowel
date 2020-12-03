package info.beans;

public class InfoBean {
    private String id;
    private String name;
    private String amd;

    public String getAmd() {
        return amd;
    }

    public void setAmd(String amd) {
        this.amd = amd;
    }

    public InfoBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender(){
        String gender = "";
        if(id.charAt(7)=='1' || id.charAt(7)=='3'){
            gender = "남성";
        }else{
            gender = "여성";
        }
        return gender;
    }

}
