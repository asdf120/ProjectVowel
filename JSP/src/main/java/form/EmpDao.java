package form;

import java.sql.*;

public class EmpDao {

    private static EmpDao instance;

    // DB 연결시 관한 변수
    private static final String dbDriver = "oracle.jdbc.driver.OracleDriver";
    private static final String dbUrl = "jdbc:oracle:thin:@localhost:1536:orcl";
    private static final String dbUser = "scott";
    private static final String dbPass = "tiger";


    private EmpDao() throws Exception {
        Class.forName(dbDriver);
    }

    public static EmpDao getInstance() throws Exception {
        if (instance == null) {
            instance = new EmpDao();
        }
        return instance;
    }

    public void insertEmp(EmpVO vo) throws Exception {
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        try {
            // 1. 연결객체 얻어오기
            con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            // 2. sql 문장 만들기
            String sql = "INSERT INTO emp (empno, ename, deptno, job,sal) VALUES (?,?,?,?,?)";
            // 3. 전송객체 얻어오기 + ? 지정
            ps = con.prepareStatement(sql);
            ps.setInt(1, vo.getEmpno());
            ps.setString(2, vo.getEname());
            ps.setInt(3, vo.getDeptno());
            ps.setString(4, vo.getJob());
            ps.setInt(5, vo.getSal());
            // 4. 전송하기
            ps.executeUpdate();

        } catch (Exception ex) {
            throw new Exception("사원정보 ) DB에 입력시 오류  : " + ex.toString());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

}
