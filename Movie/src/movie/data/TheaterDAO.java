package movie.data;

import movie.data.vo.TheaterVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TheaterDAO {
    Connection con;

    public TheaterDAO() throws Exception{
        this.con = DbSingleton.getInstance();
    }

    public List<TheaterVO> showMovie()throws  Exception{
        TheaterVO theaterVo = null;

        List<TheaterVO> movieList = new ArrayList<>();

        String sql = "SELECT t.title, theater_no, to_char(start_time, 'yy/mm/dd hh:mi') start_time " +
                " from movie m inner join theater t " +
                " on m.title = t.title " +
                " where t.start_time <= (sysdate + 7)" +
                " order by start_time";

        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        System.out.println("TheaterDAO 31행");

        while (rs.next()) {
            theaterVo = new TheaterVO();
            theaterVo.setTitle(rs.getString("TITLE"));
            theaterVo.setTheater_no(rs.getString("THEATER_NO"));
            theaterVo.setStart_time(rs.getString("START_TIME"));
            System.out.println("TheaterDAO : " + rs.getString("THEATER_NO"));
            movieList.add(theaterVo);
        }

        rs.close();
        st.close();
        return movieList;
    }

}
