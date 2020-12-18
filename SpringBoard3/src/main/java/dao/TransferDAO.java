package dao;


import domain.ReceiverVO;
import domain.SenderVO;

public interface TransferDAO {
	
	public void transfer(SenderVO sender, ReceiverVO receiver)  throws Exception;
}
