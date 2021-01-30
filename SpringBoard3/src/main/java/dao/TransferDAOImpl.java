package dao;

import domain.ReceiverVO;
import domain.SenderVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TransferDAOImpl implements TransferDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//#############################################
	/*
	 *  선언적 트랜잭션에서는 런타임 예외가 발생하면 롤백한지만 예외가 발생하지 않거나 체크 예외가 발생하면 커밋한다.
	 *  그래서 rollbackFor를 이용하여 예외를 지정한다.
	 */
	public void transfer(SenderVO send, ReceiverVO recv) throws TransException{
		int resultSend = sqlSession.update("trans.withdraw", send);
		if( resultSend == 0) throw new TransException();
		System.out.println("인출");
		int resultRecv = sqlSession.update("trans.deposit", recv);
		if( resultRecv == 0) throw new TransException();
		System.out.println("입금");
	}

}
