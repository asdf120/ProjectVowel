package movie.data.vo;

import java.util.Date;

public class ReserveVO {
    private int reserve_no; //예매번호
    private String member_id;   // 회원ID
    private String theater_no;  // 상영관번호
    private Date theater_time;  // 상영시각
    private String seat_no; //좌석번호
    private int person_num; // 인원
    private String pay_sys; // 결제방법
    private int pay_money;  // 결제금액

    public ReserveVO() {
    }

    public ReserveVO(String member_id, String theater_no, Date theater_time, String seat_no, int person_num, String pay_sys, int pay_money) {
        this.member_id = member_id;
        this.theater_no = theater_no;
        this.theater_time = theater_time;
        this.seat_no = seat_no;
        this.person_num = person_num;
        this.pay_sys = pay_sys;
        this.pay_money = pay_money;
    }

    public int getReserve_no() {
        return reserve_no;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getTheater_no() {
        return theater_no;
    }

    public void setTheater_no(String theater_no) {
        this.theater_no = theater_no;
    }

    public Date getTheater_time() {
        return theater_time;
    }

    public void setTheater_time(Date theater_time) {
        this.theater_time = theater_time;
    }

    public String getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
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
