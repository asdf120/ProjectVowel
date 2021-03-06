package movie.data;

import movie.data.vo.MemberVO;
import movie.data.vo.ReserveVO;

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
        this.con = DbSingleton.getInstance();
    }

    /**
     * RegisterView에서 호출
     * 회원가입 메소드
     */
    public void regist(MemberVO memberVo, int type) throws Exception {
        PreparedStatement st;
        System.out.println("type : " + type);
        // 회원가입
        if (type == 1) {
            String sql = " INSERT INTO member (tel,member_id,password,name,birth,email) values (?,?,?,?,?,?) ";
            st = con.prepareStatement(sql);
            System.out.println("31행");
            st.setString(1, memberVo.getTel());
            st.setString(2, memberVo.getMember_id());
            st.setString(3, memberVo.getPassword());
            st.setString(4, memberVo.getName());
            st.setDate(5, memberVo.getBirth());
            st.setString(6, memberVo.getEmail());
        } else {  // 비회원가입
            String sql = " INSERT INTO non_member (tel,birth) values (?,?) ";

            st = con.prepareStatement(sql);
            System.out.println("31행");
            st.setString(1, memberVo.getTel());
            st.setDate(2, memberVo.getBirth());
        }

        System.out.println("38행" + memberVo.getBirth());
        st.executeUpdate();
        System.out.println("40행");

        st.close();
        System.out.println("MemberDao 회원가입 성공");
    }

    /**
     * LoginView에서 호출
     * 로그인 메소드
     */
    public ReserveVO login(String id,String pass) throws Exception {
        ReserveVO reserveVo = new ReserveVO();

        String sql = "SELECT * FROM member WHERE member_id=? and password = ?";

        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1, id);
        st.setString(2, pass);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            reserveVo.setMember_tel(rs.getString("tel"));
        } else {
            reserveVo.setMember_tel(null);
        }
        System.out.println("48행");
        rs.close();
        st.close();

        return reserveVo;

    }

    /**
     * 아이디 찾기 메소드
     */
    public String searchId(String tel) throws Exception {
        String findID = null;
        String sql ="SELECT member_id FROM member WHERE tel=?";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, tel);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            findID = rs.getString("member_id"); // 찾아온 아이디 담기
        }

        rs.close();
        st.close();

        return findID;
    }

    /**
     * SearchPWView에서 호출
     * 비번 찾기 메소드
     */
    public String searchPw(String name, String tel) throws Exception {
        String email = null;

        // sql 작성
        String sql = "SELECT * FROM member WHERE name = ? and tel = ?";
        System.out.println(sql + "," + name + "," + tel);
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, name);
        st.setString(2, tel);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            email = rs.getString("EMAIL");
        }
        rs.close();
        st.close();
        return email;
    }

    /**
     * 비번변경 메소드
     */
    public void changePw(String email, String password) throws Exception {
        String sql = "UPDATE member SET password = ? WHERE email = ? ";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, password);
        st.setString(2, email);

        st.executeUpdate();

        st.close();
    }

    /**
     * 회원정보 변경
     */
    public void modifyInfo(MemberVO memberVo, ReserveVO reserveVo) throws Exception{
        String sql = "update member set name = ?, email = ?, password = ? where tel = ? ";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,memberVo.getName());
        st.setString(2,memberVo.getEmail());
        st.setString(3,memberVo.getPassword());
        st.setString(4,reserveVo.getMember_tel());
        st.executeUpdate();

        st.close();
    }
}
