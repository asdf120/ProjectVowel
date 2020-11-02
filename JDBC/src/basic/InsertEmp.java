package basic;

import java.sql.*;

public class InsertEmp {
    public static void main(String[] args) {
        // 1. 드라이버를 메모리 로딩
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로딩 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
        }

//         2. 연결객체 얻어오기
        String url = "jdbc:oracle:thin:@192.168.0.51:1521:orcl";    // 내 ip db 연결
        String user = "scott";
        String pass = "tiger";

//        String url = "jdbc:oracle:thin:@192.168.0.57:1521:orcl";
//        String user = "team10";
//        String pass = "team10";
        
        try {
            Connection con = DriverManager.getConnection(url,user,pass);
            System.out.println("연결성공");

            // 3. SQL 만들기
            String name = "홍길동2";
            int sal = 3000;

            String sql = "insert into emp (empno, ename,sal,deptno) " +
                    " values(7005,'" + name + "', " + sal + " ,30)";

            System.out.println(sql);

            // 4. SQL 전송객체 얻어오기
            Statement st = con.createStatement();
            System.out.println("createStatement");
            // 5. 전송하기
            st.executeUpdate(sql);  // 외부에서 db를 조작할때는 auto commit --> rollback 절대 불가
            System.out.println("executeUpdate");
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
