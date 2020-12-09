package mvc_board.command;

import mvc_board.model.BoardDao;
import mvc_board.model.BoardException;
import mvc_board.model.BoardVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BoardCommandList implements BoardCommand
{
	private String next;

	public BoardCommandList(String next ){
		this.next = next;
	}

	public String execute( HttpServletRequest request , HttpServletResponse response  ) throws BoardCommandException{
		try{
		    List <BoardVO> mList = BoardDao.getInstance().selectList();
		    request.setAttribute("mList", mList );

		}catch( BoardException ex ){
			throw new BoardCommandException("" +
					".java < 목록보기시 > " + ex.toString() );
		}
		
		return next;
	}
}
