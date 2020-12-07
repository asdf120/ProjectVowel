package board.service;

import java.text.DecimalFormat;

import board.model.*;

public class WriteArticleService {
	
	private static WriteArticleService instance;
	public static WriteArticleService getInstance()  throws BoardException{
		if( instance == null )
		{
			instance = new WriteArticleService();
		}
		return instance;
	}
	
	public int write( BoardVO boardVo ) throws BoardException{
		
		BoardDao dao = BoardDao.getInstance();

		// 그룹번호(group_id) 지정
		int groupId = dao.getGroupId();
		boardVo.setGroupId(groupId);
		
		// 순서번호(sequence_no) 지정
		DecimalFormat dFormat = new DecimalFormat("0000000000");
		boardVo.setSequenceNo( dFormat.format(groupId) + "999999");
		/**
		 * ex)
		 * 그룹번호(group_id) : 7
		 * 순서번호 (sequence_no) : 0000000007999999
		 */
		
		// DB에 insert
		int article_id = dao.insert(boardVo);
			
		return article_id;
		
	}
}
