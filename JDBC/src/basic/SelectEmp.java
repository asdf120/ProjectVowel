package basic;

import java.sql.*;

public class SelectEmp {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";    // 내 ip db 연결
//            String user = "scott";
//            String pass = "tiger";
            String user = "kosmo_04";
            String pass = "kosmo";


            con = DriverManager.getConnection(url, user, pass);
            System.out.println("연결성공");

            String job = "SALESMAN";
            int deptno = 30;
//            String sql = " SELECT * FROM emp WHERE job = '"+ job + "' and deptno = " + deptno + " ";
            String sql = "SELECT * FROM account";
            System.out.println(sql);

            st = con.createStatement();

            rs = st.executeQuery(sql);
            while (rs.next()) {
//                System.out.print("사번 : " +rs.getInt("EMPNO")+ " ");
//                System.out.print("이름 : " +rs.getString("ENAME")+ " ");
//                System.out.print("직무 : " +rs.getString("JOB")+ " ");
//                System.out.print("급여 : " +rs.getInt("SAL")+ " ");
//                System.out.println("부서번호 : " +rs.getInt("DEPTNO"));
                System.out.print(rs.getString("account_num")+ " ");
                System.out.print(rs.getString("customer")+ " ");
                System.out.println(rs.getInt("amount"));
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
