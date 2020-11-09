package movie.data.vo;

public class SeatVO {
    private String col;  // 좌석 열
    private String row;    // 좌석 행
    private String status;        // 좌석 선택 여부


    public SeatVO() {}
    public SeatVO(String col, String row, String status) {
        this.col = col;
        this.row = row;
        this.status = status;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String addColRow(String col, String row){
        String colrow = col+row;
        return colrow;
    }
}
