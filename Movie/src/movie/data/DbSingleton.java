package movie.data;

import videoshop.model.DBCon;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbSingleton {
    private static Connection con;

    String url;
    String user;
    String pass;

    private DbSingleton()throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1536:orcl", "theater", "theater");
//        con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.57:1521:orcl", "team10", "team10");
    }
    public static Connection getInstance() throws Exception {
        if (con == null) {
            new DbSingleton();
        }
        return con;
    }
}

