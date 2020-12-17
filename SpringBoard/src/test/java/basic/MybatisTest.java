package basic;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)

public class MybatisTest {

	
	private DataSource dataSource;
	
	
	private SqlSessionFactory sqlSessionFactory;
	
	
	public void timeTest() {
		try {
		
			SqlSession session = sqlSessionFactory.openSession();
			Connection con = session.getConnection();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
