package basic;

import java.sql.Connection;
import java.sql.DriverManager;


public class JdbcTest {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void testConnection() {
		try {
			Connection con = 
			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1536:orcl",
					"kyg", "1234");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
