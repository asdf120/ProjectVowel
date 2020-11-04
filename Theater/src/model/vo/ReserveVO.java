package src.model.vo;

import java.util.Date;

public class ReserveVO {
    private int reserve_no; //예매번호
    private String member_id;
    private String title;
    private String theater;
    private Date see_date;  // 관람시각
    private int person_num; // 인원
    private String pay_sys; // 결제방법
    private int pay_money;  // 결제금액

    public ReserveVO() {
    }

    public ReserveVO(int reserve_no, String member_id, String title, String theater, Date see_date, int person_num, String pay_sys, int pay_money) {
        this.reserve_no = reserve_no;
        this.member_id = member_id;
        this.title = title;
        this.theater = theater;
        this.see_date = see_date;
        this.person_num = person_num;
        this.pay_sys = pay_sys;
        this.pay_money = pay_money;
    }

    public int getReserve_no() {
        return reserve_no;
    }

    public void setReserve_no(int reserve_no) {
        this.reserve_no = reserve_no;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public Date getSee_date() {
        return see_date;
    }

    public void setSee_date(Date see_date) {
        this.see_date = see_date;
    }

    public int getPerson_num() {
        return person_num;
    }

    public void setPerson_num(int person_num) {
        this.person_num = person_num;
    }

    public String getPay_sys() {
        return pay_sys;
    }

    public void setPay_sys(String pay_sys) {
        this.pay_sys = pay_sys;
    }

    public int getPay_money() {
        return pay_money;
    }

    public void setPay_money(int pay_money) {
        this.pay_money = pay_money;
    }
}
