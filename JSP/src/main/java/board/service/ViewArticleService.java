package board.service;

import board.model.BoardDao;
import board.model.BoardException;
import board.model.BoardVO;

public class ViewArticleService {
	private static ViewArticleService instance;
	public static ViewArticleService getInstance()  throws BoardException{
		if( instance == null )
		{
			instance = new ViewArticleService();
		}
		return instance;
	}
	
	public BoardVO getArticleById(String id) throws BoardException
	{
		int article_id = 0;
		if( id != null ) article_id = Integer.parseInt(id);

		BoardDao dao = BoardDao.getInstance();
		BoardVO boardVO = dao.selectById(article_id);

		dao.increaseReadCount(article_id);
		return boardVO;
	}
		
}

