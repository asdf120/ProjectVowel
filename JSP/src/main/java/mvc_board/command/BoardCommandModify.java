package mvc_board.command;


import mvc_board.model.BoardDao;
import mvc_board.model.BoardException;
import mvc_board.model.BoardVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardCommandModify implements BoardCommand {

    String next;

    public BoardCommandModify(String next) {
        this.next = next;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws BoardCommandException {
        try{
            String id = request.getParameter("articleId");
            int articleId = 0;
            if (id != null) {
                articleId = Integer.parseInt(id);
            }
            BoardVO boardVO = new BoardVO();
            boardVO.setArticleId(articleId);
            boardVO.setTitle(request.getParameter("title"));
            boardVO.setPassword(request.getParameter("password"));
            boardVO.setContent(request.getParameter("title"));

            int result = BoardDao.getInstance().update(boardVO);

            request.setAttribute("result",result);
            request.setAttribute("articleId", articleId);
        }catch (Exception e){
            throw new BoardCommandException("BoardCommandModify 수정 : " + e.toString());
        }
        return next;
    }
}
