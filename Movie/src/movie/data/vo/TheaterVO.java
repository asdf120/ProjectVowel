package movie.data.vo;

import java.util.Date;

public class TheaterVO {
    private String theater_no;  // 상영관 번호
    private Date theater_time;    // 상영시각
    private String title;       // 영화제목
    private int seat_num; // 좌석갯수

    public TheaterVO() {
    }

    public TheaterVO(String theater_no, Date theater_time, String title, int seat_num) {
        this.theater_no = theater_no;
        this.theater_time = theater_time;
        this.title = title;
        this.seat_num = seat_num;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSeat_num() {
        return seat_num;
    }

    public void setSeat_num(int seat_num) {
        this.seat_num = seat_num;
    }
}
