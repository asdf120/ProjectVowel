package videoshop.model.vo;

public class VideoVO {
    private int video_no;
    private String title;
    private String genre;
    private String director;
    private String actor;
    private String detail;

    public VideoVO() {
    }

    public VideoVO(String title, String genre, String director, String actor, String detail) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.actor = actor;
        this.detail = detail;
    }

    public int getVideo_no() {
        return video_no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
