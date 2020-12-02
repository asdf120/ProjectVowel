package loginform;

import java.sql.*;

public class UserDao {
    Connection con;
    private static final String dbUrl = "jdbc:oracle:thin:@localhost:1536:orcl";
    private static final String dbUser = "kyg";
    private static final String dbPass = "1234";

    public UserDao() {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
        }catch (Exception e){
            System.out.println("UserDao DB연결 실패");
            System.out.println(e.toString());
        }
    }

    public boolean login(String id, String pswd){
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM account WHERE id = ? and pswd = ? ";
        try{
            st = con.prepareStatement(sql);
            st.setString(1,id);
            st.setString(2,pswd);
            rs = st.executeQuery();
            while(rs.next()){
                return true;
            }
        }catch (Exception e){
            System.out.println("sql오류");
            System.out.println(e.toString());
        }finally {
            try{
                rs.close();
                st.close();
            }catch (Exception e){
                e.toString();
            }
        }
        return false;
    }
}
