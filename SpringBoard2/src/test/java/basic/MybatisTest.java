package basic;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:../../../web/WEB-INF/springConfig/dispatcher-servlet.xml")
public class MybatisTest {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void timeTest() {
		try {
		
			SqlSession session = sqlSessionFactory.openSession();
			Connection con = session.getConnection();
			System.out.println("[테스트]"+session.selectOne("org.javassem.TestMapper.getTime"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
