package jdbc.gui;

import java.sql.*;
import java.util.*;

public class InfoModelImpl {
    Connection con;
    PreparedStatement st;
    String url;    // 내 ip db 연결
    String user;
    String pass;
	/*---------------------------------------------
	 * 생성자 함수 
	 	1. DB 연동
	 		- 드라이버 등록
	*/

    public InfoModelImpl() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        url = "jdbc:oracle:thin:@localhost:1521:orcl";
        user = "scott";
        pass = "tiger";
    }

    /*-------------------------------------------------------
    * insert() : db에 입력한 값 받아서 추가
        0. 연결객체 얻어오기
        1. sql문 만들기 ( insert 구문 )
        2. PreparedStatement 객체 생성 ( 또는 Statement )
        3. PreparedStatement에 인자 지정
        4. sql문 전송 ( executeUpdate() 이용 )
        5. PreparedStatement 닫기
        6. 연결 닫기
    */
    public void insert(InfoVO infoVO) throws SQLException {
        try {
            con = DriverManager.getConnection(url, user, pass);
            String sql = " INSERT INTO info (name, tel, jumin, gender, age, home) VALUES (?,?,?,?,?,?) ";

            st = con.prepareStatement(sql);
            st.setString(1, infoVO.getName());
            st.setString(2, infoVO.getTel());
            st.setString(3, infoVO.getId());
            st.setString(4, infoVO.getSex());
            st.setInt(5, infoVO.getAge());
            st.setString(6, infoVO.getHome());

            int result = st.executeUpdate();
            System.out.println(result + "행을 입력");
        } catch (Exception e) {
            System.out.println("impl 51행 " + e.toString());
        } finally {
            try {
                st.close();
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    /*-------------------------------------------------------
    * selectAll() : dbtest 테이블의 전체 레코드 검색
        1. 연결객체 얻어오기
        2. sql문 만들기 ( select 구문 )
        3. PreparedStatement 객체 얻기
        4. sql문 전송 ( executeQuery() 이용 )
        5. 결과집합(ResultSet)에서 값을 읽어서 ArrayList에 저장
        6. ResultSet/ Statement 닫기
        7. 연결 닫기
        8. Vector 리턴
    */
    public ArrayList selectAll() throws SQLException {
        ArrayList<InfoVO> list = new ArrayList<>();
        try {
            con = DriverManager.getConnection(url, user, pass);

            String sql = "SELECT * FROM info";
            st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                InfoVO infoVO = new InfoVO();
                infoVO.setName(rs.getString("NAME"));
                infoVO.setId(rs.getString("JUMIN"));
                infoVO.setTel(rs.getString("TEL"));
                infoVO.setSex(rs.getString("GENDER"));
                infoVO.setAge(rs.getInt("AGE"));
                infoVO.setHome(rs.getString("HOME"));
                list.add(infoVO);
            }
//			list.add(st.executeQuery());

        } finally {
            try {
                st.close();
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return list;
    }

    public void modify(InfoVO infoVO) throws SQLException {
        try {
            con = DriverManager.getConnection(url, user, pass);

            String sql = " UPDATE info " +
                    "SET NAME = ? ,JUMIN = ? ,GENDER = ?,AGE = ?,HOME = ? " +
                    "where TEL = ? ";
            st = con.prepareStatement(sql);
            
            st.setString(1, infoVO.getName());
            st.setString(2, infoVO.getId());
            st.setString(3, infoVO.getSex());
            st.setInt(4, infoVO.getAge());
            st.setString(5, infoVO.getHome());

            st.setString(6, infoVO.getTel());

            st.executeUpdate();
        } finally {
            try {
                st.close();
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    /*--------------------------------------------------------
    * delete() : 전화번호 값을 받아 해당 레코드 삭제
        0. 연결객체 얻어오기
        1. sql문 만들기 ( delete 구문 )
        2. Statement 객체 얻기
        3. sql문 전송 ( executeUpdate() 이용 )
        4. Statement 닫기
        5. 연결 닫기
    */
    public int delete(String tel) throws SQLException {
        int resultCnt = 0;
        try{
            con = DriverManager.getConnection(url,user,pass);
            String sql = "DELETE FROM info where TEL = ? ";

            st = con.prepareStatement(sql);

            st.setString(1,tel);

            resultCnt = st.executeUpdate();
        }finally {
            st.close();
            con.close();
        }
        return resultCnt;
    }

    public InfoVO searchByTel(String tel) throws SQLException {
        InfoVO infoVO = new InfoVO();
        try {
            con = DriverManager.getConnection(url, user, pass);

            String sql = "SELECT * FROM info where tel = ?";
            st = con.prepareStatement(sql);
            st.setString(1, tel);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                infoVO.setName(rs.getString("NAME"));
                infoVO.setId(rs.getString("JUMIN"));
                infoVO.setTel(rs.getString("TEL"));
                infoVO.setSex(rs.getString("GENDER"));
                infoVO.setAge(rs.getInt("AGE"));
                infoVO.setHome(rs.getString("HOME"));
            }
        } finally {
            try {
                st.close();
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return infoVO;
    }
}