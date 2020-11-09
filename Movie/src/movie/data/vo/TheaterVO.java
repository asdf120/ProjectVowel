package movie.data.vo;

import java.util.Date;

public class TheaterVO {
    private String theater_no;  // 상영관 번호
    private String start_time;  // 상영시각
    private String title;       // 영화제목
    private int seat_num; // 좌석갯수

    // 러닝타임으로 시간을 계산하기 위해 필요
    private int run_time;

    public TheaterVO() {
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

    public int getRun_time() {
        return run_time;
    }

    public void setRun_time(int run_time) {
        this.run_time = run_time;
    }
}
