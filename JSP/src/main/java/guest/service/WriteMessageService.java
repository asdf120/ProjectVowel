package guest.service;

import guest.model.MessageDao;
import guest.model.MessageException;
import guest.vo.MessageVO;
import member.beans.MemberDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class WriteMessageService {

	private static WriteMessageService instance;

	
	public static WriteMessageService	getInstance() throws MessageException
	{
		if( instance == null )
		{
			instance = new WriteMessageService();
		}
		return instance;
	}
	
	private WriteMessageService()
	{

	}
	
	public void write( MessageVO messageVO ) throws MessageException
	{
		MessageDao mDao = MessageDao.getInstance();
		mDao.insert(messageVO);
	
	}
}
