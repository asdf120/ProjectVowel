package videoshop.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {
    private static Connection con;

    String url;
    String user;
    String pass;

    private DBCon() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
//      con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kosmo_04", "kosmo");
        con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.57:1521:orcl", "team10", "team10");
    }

    public static Connection getInstance() throws Exception {
        if (con == null) {
            new DBCon();
        }
        return con;
    }
}
