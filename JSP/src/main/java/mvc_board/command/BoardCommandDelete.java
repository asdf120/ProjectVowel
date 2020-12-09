package mvc_board.command;

import board.model.BoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardCommandDelete implements BoardCommand {
    String next = null;

    public BoardCommandDelete(String next) {
        this.next = next;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws BoardCommandException {
        try{
            String id = request.getParameter("articleId");
            String password = request.getParameter("password");

            int articleId = 0;
            if (id != null) {
                articleId = Integer.parseInt(id);
            }

            int result = BoardDao.getInstance().delete(articleId,password);

            request.setAttribute("result",result);

        }catch (Exception e){
            throw new BoardCommandException("BoardCommandDelete 오류 : " + e.toString());
        }
        return next;
    }
}
