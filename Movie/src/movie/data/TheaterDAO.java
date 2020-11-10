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

    /**
     * TheaterView에 상영중인 영화를 띄워줌
     */
    public List<TheaterVO> showMovie()throws  Exception{
        TheaterVO theaterVo = null;

        List<TheaterVO> movieList = new ArrayList<>();

//        String sql = "SELECT distinct(t.title, theater_no), to_char(start_time, 'yy/mm/dd hh:mi') start_time " +
//                " from movie m inner join theater t " +
//                " on m.title = t.title " +
//                " where t.start_time <= (sysdate + 3)" +
//                " order by start_time";
        String sql = "SELECT DISTINCT t.title " +
                " FROM theater t, movie m " +
                " WHERE t.start_time <= m.end_day";

        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            theaterVo = new TheaterVO();
            theaterVo.setTitle(rs.getString("TITLE"));
//            theaterVo.setTheater_no(rs.getString("THEATER_NO"));
//            theaterVo.setStart_time(rs.getString("START_TIME"));
            movieList.add(theaterVo);
        }

        rs.close();
        st.close();
        return movieList;
    }

    /**
     * ReserveView에 상영시간표를 띄워줌
     */
    public List<TheaterVO> showMovie_Time(String title) throws Exception{
        TheaterVO theaterVO;
        List<TheaterVO> theaterVOList = new ArrayList<>();

        String sql = "SELECT to_char(start_time, 'yy/mm/dd hh24:mi') start_time, m.run_time run_time " +
                " FROM theater t INNER JOIN movie m " +
                " ON t.title = m.title " +
                " WHERE t.title = ? " +
                " ORDER BY start_time";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,title);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            theaterVO = new TheaterVO();
            theaterVO.setStart_time(rs.getString("START_TIME"));
            theaterVO.setRun_time(rs.getInt("RUN_TIME"));
            theaterVOList.add(theaterVO);
        }
        rs.close();
        st.close();

        return theaterVOList;
    }
}
