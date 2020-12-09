package mvc_board.command;

import mvc_board.model.BoardDao;
import mvc_board.model.BoardVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.util.List;

public class BoardCommandInsert implements BoardCommand {
    String next = "";

    public BoardCommandInsert(String next) {
        this.next = next;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws BoardCommandException {
        try{
            BoardVO boardVO = new BoardVO();
            boardVO.setWriterName(request.getParameter("writerName"));
            boardVO.setTitle(request.getParameter("title"));
            boardVO.setContent(request.getParameter("content"));
            boardVO.setPassword(request.getParameter("password"));

            int groupId = BoardDao.getInstance().getGroupId();
            boardVO.setGroupId(groupId);

            // 순서번호(sequence_no) 지정
            DecimalFormat dFormat = new DecimalFormat("0000000000");
            boardVO.setSequenceNo( dFormat.format(groupId) + "999999");

            BoardDao.getInstance().insert(boardVO);

            List<BoardVO> mList = BoardDao.getInstance().selectList();
            request.setAttribute("mList", mList );

        }catch (Exception e){
            throw new BoardCommandException("BoardCommandInsert 오류  : " + e.toString());
        }

        return next;
    }
}
