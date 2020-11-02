package basic;

import java.sql.*;

public class SelectEmpPrep {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";    // 내 ip db 연결
            String user = "scott";
            String pass = "tiger";

            con = DriverManager.getConnection(url, user, pass);
            System.out.println("연결성공");

            String job = "SALESMAN";
            int deptno = 30;
            String sql = " SELECT * FROM emp WHERE job = ? and deptno = ?";
            // 업무가 'SALESMAN' & 부서번호 30인 사원정보
//            String sql = "SELECT * FROM emp WHERE "
            System.out.println(sql);

            st = con.prepareStatement(sql);
            st.setString(1,job);
            st.setInt(2,deptno);


            rs = st.executeQuery();
            while (rs.next()) {
                System.out.print("사번 : " +rs.getInt("EMPNO")+ " ");
                System.out.print("이름 : " +rs.getString("ENAME")+ " ");
                System.out.print("직무 : " +rs.getString("JOB")+ " ");
                System.out.print("급여 : " +rs.getInt("SAL")+ " ");
                System.out.println("부서번호 : " +rs.getInt("DEPTNO"));
            }
        } catch (Exception e) {
            System.out.println("예외발생 : " + e.toString());
        } finally {
            try {
                rs.close();
                st.close();
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
