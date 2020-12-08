package mybatis.guest.session;

import mybatis.guest.model.CommentVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * 모델에 해당
 */
public class CommentRepository 
{
	//	private final String namespace = "CommentMapper";

	private SqlSessionFactory getSqlSessionFactory() {
		
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		SqlSessionFactory sessFactory =  new SqlSessionFactoryBuilder().build(inputStream);
		return sessFactory;
	}

	/**
	 * TODO
	 * JDBC에서 연결을 담당 : Connection
	 * Mybatis : SqlSession
	 */
	public List<CommentVO> selectComment(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try{
			return sqlSession.selectList("CommentMapper.selectComment");
		}finally{
			/**
			 * 	실제적으로 연결을 닫는 것이 아니라 반납하는것
			 * 	Mybatis는 미리 연결객체(Connection)을 여러개 열어놓고
			 * 	ConnectionPool을 관리함
			 */
			sqlSession.close();
		}
	}

	/**
	 * 글 등록
	 */
    public Integer insertComment(CommentVO commentVO) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			int result = sqlSession.insert("CommentMapper.insertComment",commentVO);
			if(result > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
			return result;
		}finally {
			sqlSession.close();
		}
    }

	public CommentVO selectCommentByPrimaryKey(long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			HashMap map = new HashMap<>();
			 map.put("commentNo",commentNo);
			// 1개 받을땐 selectOne, 여러개일땐 selectList
			return sqlSession.selectOne("CommentMapper.selectComment",map);
		}finally {
			sqlSession.close();
		}
	}

	public Integer modifyComment(CommentVO commentVO) {
    	SqlSession sqlSession = getSqlSessionFactory().openSession();
        System.out.println("CommentRepository 85Line : " + commentVO.getUserId());
        try{
    		int result = sqlSession.update("CommentMapper.modifyComment",commentVO);
            if(result>0){
                sqlSession.commit();
            }else{
                sqlSession.rollback();
            }
            return result;
		}finally {
    		sqlSession.close();
		}
	}

    public Integer deleteComment(long commentNo) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        try{
            int result = sqlSession.delete("CommentMapper.deleteComment",commentNo);
            if(result>0){
                sqlSession.commit();
            }else{
                sqlSession.rollback();
            }
            return result;
        }finally {
            sqlSession.close();
        }
    }
}
