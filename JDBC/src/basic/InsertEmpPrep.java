package basic;

import java.sql.*;

public class InsertEmpPrep {
    public static void main(String[] args) {

        // 1. 드라이버를 메모리 로딩
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로딩 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
        }

//         2. 연결객체 얻어오기
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";    // 내 ip db 연결
        String user = "scott";
        String pass = "tiger";

//        String url = "jdbc:oracle:thin:@192.168.0.57:1521:orcl";
//        String user = "team10";
//        String pass = "team10";
        
        try {
            Connection con = DriverManager.getConnection(url,user,pass);
            System.out.println("연결성공");

            String name = "홍길동3";
            int sal = 3000;

            // 3. SQL 만들기
            String sql = "insert into emp (empno, ename,sal,deptno) " +
                    " values(7007,?,?,10)";
            System.out.println(sql);

            // 4. SQL 전송객체 얻어오기
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,name);
            st.setInt(2,sal);
            // 5. 전송하기
            st.executeUpdate(); // **************TODO sql절대 넣지말것 ******************

            // 6. 닫기
            st.close();
            System.out.println("st close()");
            con.close();;
            System.out.println("con close()");
        } catch (SQLException e) {
            System.out.println("연결 실패 " + e.toString());
        }
    }
}
