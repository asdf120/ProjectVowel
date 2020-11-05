package movie.data;

import movie.data.vo.MemberVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    MemberVO memberVo;
    Connection con;

    public MemberDAO() throws Exception {
        connectDB();
    }

    public void connectDB() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "theater", "theater");
    }

    /**
     * 회원가입 메소드
     */
    public void regist() throws Exception {

    }

    /**
     * 로그인 메소드
     */
    public int login(String id) throws Exception {
        int result =0;

        String sql = "SELECT * FROM member WHERE member_id=?";

        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1, id);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            result = 0;
        }else{
            result = -1;
        }
        System.out.println("48행");
        rs.close();
        st.close();

        return result;

    }

    /**
     * 아이디 찾기 메소드
     */
    public void searchId() throws Exception {

    }

    /**
     * 비번 찾기 메소드
     */
    public String searchPw(String name, String tel) throws Exception {
        String email = null;

        // sql 작성
        String sql = "SELECT * FROM member WHERE name = ? and tel = ?";
        System.out.println(sql + ","+ name +"," + tel);
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, name);
        st.setString(2, tel);
        ResultSet rs = st.executeQuery();
        if (rs.next()){
            email = rs.getString("EMAIL");
        }
        rs.close();
        st.close();
        return email;
    }

    /**
     * 비번변경 메소드
     */
    public void changePw(String email,String password) throws Exception {
         String sql = "UPDATE member SET password = ? WHERE email = ? ";

         PreparedStatement st = con.prepareStatement(sql);
         st.setString(1,password);
         st.setString(2,email);

         st.executeUpdate();

         st.close();
    }
}
