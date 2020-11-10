package movie.data.vo;

public class ReserveVO {
    private int reserve_no; //예매번호
    private String member_tel;   // 회원전화번호
    private String non_member_tel; // 비회원 전화번호
    private String theater_no;  // 상영관번호
    private String start_time;  // 상영시각
    private String seat_no; //좌석번호
    private int person_num; // 인원
    private String pay_sys; // 결제방법
    private int pay_money;  // 결제금액


    public ReserveVO() {
    }

    public void setReserve_no(int reserve_no) {
        this.reserve_no = reserve_no;
    }

    public String getMember_tel() {
        return member_tel;
    }

    public void setMember_tel(String member_tel) {
        this.member_tel = member_tel;
    }

    public String getNon_member_tel() {
        return non_member_tel;
    }

    public void setNon_member_tel(String non_member_tel) {
        this.non_member_tel = non_member_tel;
    }

    public int getReserve_no() {
        return reserve_no;
    }

    public String getTheater_no() {
        return theater_no;
    }

    public void setTheater_no(String theater_no) {
        this.theater_no = theater_no;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
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
