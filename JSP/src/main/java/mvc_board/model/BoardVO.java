package mvc_board.model;

public class BoardVO {
    // member field
    private int articleId;        // 게시글번호
    private int groupId;            // 그룹번호
    private String sequenceNo;    // 순서번호
    private String postingDate;    // 게시날짜
    private int readCount;        // 조회수
    private String writerName;    // 작성자
    private String password;        // 비밀번호
    private String title;                // 제목
    private String content;            // 내용


    // constructor method
    public BoardVO() {

    }

    public BoardVO(int groupId, String sequenceNo, String postingDate, int readCount, String writerName, String password, String title, String content) {
        this.groupId = groupId;
        this.sequenceNo = sequenceNo;
        this.postingDate = postingDate;
        this.readCount = readCount;
        this.writerName = writerName;
        this.password = password;
        this.title = title;
        this.content = content;
    }

    // setter
    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // getter
    public int getArticleId() {
        return articleId;
    }

    public int getGroupId() {
        return groupId;
    }

    public String getSequenceNo() {
        return sequenceNo;
    }

    public String getPostingDate() {
        return postingDate;
    }

    public int getReadCount() {
        return readCount;
    }

    public String getWriterName() {
        return writerName;
    }

    public String getPassword() {
        return password;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getLevel() {
        if (sequenceNo == null) {
            return -1;
        }
        if (sequenceNo.length() != 16) {
            return -1;
        }
        if (sequenceNo.endsWith("999999")) {
            return 0;
        }
        if (sequenceNo.endsWith("9999")) {
            return 1;
        }
        if (sequenceNo.endsWith("99")) {
            return 2;
        }
        return 3;
    }
}
