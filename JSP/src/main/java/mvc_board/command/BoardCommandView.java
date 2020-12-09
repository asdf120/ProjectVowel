package mvc_board.command;

import mvc_board.model.BoardDao;
import mvc_board.model.BoardException;
import mvc_board.model.BoardVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardCommandView implements BoardCommand {

    private String next;

    public BoardCommandView(String next ){
        this.next = next;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws BoardCommandException {
        try{
            BoardDao boardDao = BoardDao.getInstance();
            String id = request.getParameter("articleId");
            int articleId = 1;
            if(id != null){
                 articleId = Integer.parseInt(id);
            }

            BoardVO boardVO = boardDao.selectById(articleId);
            boardDao.increaseReadCount(articleId);

            request.setAttribute("boardVo", boardVO);
        }catch (BoardException e){
            throw new BoardCommandException("BoardCommandView 게시글 보기 : " + e.toString());
        }
        return next;
    }
}
