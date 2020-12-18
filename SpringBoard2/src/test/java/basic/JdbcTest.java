package basic;

import org.junit.Test;
import org.junit.runner.RunWith;

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
	
	@Test
	public void testConnection() {
		try {
			Connection con =
			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1536:orcl",
					"kyg", "1234");

			System.out.println("DB연동 테스트 성공");

		} catch (Exception e) {
			System.out.println("DB연동 테스트 실패");
			e.printStackTrace();
		}
	}
}
