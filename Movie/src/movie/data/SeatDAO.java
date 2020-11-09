package movie.data;

import movie.data.vo.SeatVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SeatDAO {
    Connection con;
    SeatVO seatVo[][];
    SeatVO seatVo_test;

    public SeatDAO() throws Exception {
        con = DbSingleton.getInstance();
    }

    public void connectDB() throws Exception {
        this.con = DbSingleton.getInstance();
    }

    public SeatVO[][] regist() throws Exception {
        seatVo = new SeatVO[5][9];
        int i = 0;
        int j = 0;
        String sql = "SELECT row_no, column_no, seat_status FROM theater_seat WHERE to_char(start_time, 'yy/mm/dd hh24:mi') = '20/11/09 01:06'";

        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            seatVo_test = new SeatVO();
            if (j == 9) {
                i++;
                j = 0;
            }
            seatVo_test.setRow(rs.getString("row_no"));
            seatVo_test.setCol(rs.getString("column_no"));
            seatVo_test.setStatus(rs.getString("seat_status"));

            seatVo[i][j] = seatVo_test;

            j++;
        }
        rs.close();
        st.close();

        return seatVo;
    }
}
