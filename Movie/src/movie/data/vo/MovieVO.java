package movie.data.vo;

public class MovieVO {
    private String title;    // 제목
    private int run_time;    // 러닝타임
    private String director; // 감독
    private String actor;    // 배우
    private int audi_num;    // 누적관객 수
    private String end_day; // 상영종료날짜
    private String img_loc; // 이미지 경로

    public MovieVO() {

    }

    public MovieVO(String title, int run_time, String director, String actor, int audi_num) {
        this.title = title;
        this.run_time = run_time;
        this.director = director;
        this.actor = actor;
        this.audi_num = audi_num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRun_time() {
        return run_time;
    }

    public void setRun_time(int run_time) {
        this.run_time = run_time;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public int getAudi_num() {
        return audi_num;
    }

    public void setAudi_num(int audi_num) {
        this.audi_num = audi_num;
    }

    public String getEnd_day() {
        return end_day;
    }

    public void setEnd_day(String end_day) {
        this.end_day = end_day;
    }

    public String getImg_loc() {
        return img_loc;
    }

    public void setImg_loc(String img_loc) {
        this.img_loc = img_loc;
    }
}
