package movie.data;

import movie.data.vo.MovieVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MovieDAO {
    MovieVO movieVo;
    Connection con;
    PreparedStatement st;
    ResultSet rs;
    ArrayList<MovieVO>  movieList;     ;

    public MovieDAO() throws Exception {
        this.con = DbSingleton.getInstance();
    }

    public void regist(MovieVO movieVo) throws  Exception {
        PreparedStatement st;
        String sql = " INSERT INTO movie(title,run_time,end_day,director,actor,img_loc,audi_num) values (?,?,?,?,?,?,0) ";
        st = con.prepareStatement(sql);
        st.setString(1, movieVo.getTitle());
        st.setString(2, String.valueOf(movieVo.getRun_time()));
        st.setString(3, String.valueOf(movieVo.getEnd_day()));
        st.setString(4, movieVo.getDirector());
        st.setString(5, movieVo.getActor());
        st.setString(6, movieVo.getImg_loc());

        System.out.println("오디?");
        st.executeUpdate();
        System.out.println("너냐??");
        st.close();
    }

    public void delete(String title) throws  Exception {
        PreparedStatement st;
        String sql = " DELETE FROM movie WHERE title = ? ";
        st = con.prepareStatement(sql);
        st.setString(1, title);

        System.out.println("오디?");
        st.executeUpdate();
        System.out.println("너냐??");
        st.close();
    }


    public ArrayList<MovieVO> showMovie() throws Exception {


        String sql = "SELECT title, img_loc, run_time FROM movie WHERE sysdate<=end_day";
        movieList = new ArrayList<MovieVO>();

        System.out.println(sql);
        st = con.prepareStatement(sql);

        //st.setString(1, "end_day");

        rs = st.executeQuery();
        int i= 0;
        while (rs.next()) {
            movieVo = new MovieVO();
            movieVo.setTitle(rs.getString("title"));
            movieVo.setImg_loc(rs.getString("img_loc"));
            movieVo.setRun_time(rs.getInt("run_time"));
            movieList.add(movieVo);
            System.out.println(i + movieList.get(i).getTitle());
            System.out.println(i + movieList.get(i).getImg_loc());
            i++;
        }
        System.out.println("??????????????????????");
        System.out.println(movieList.size());
        for(int j=0; j<movieList.size(); j++) {

            System.out.println(j + movieList.get(j).getTitle());
        }


        rs.close();
        st.close();

        return movieList;

    }
}