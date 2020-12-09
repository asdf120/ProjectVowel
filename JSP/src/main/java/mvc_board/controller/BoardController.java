package mvc_board.controller;

import mvc_board.command.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class BoardController extends HttpServlet {

    private String	jspDir = "/mvc_board/";
    private String error = "error.jsp";
    private HashMap commandMap;

    public BoardController() {
        initController();
    }

    public void initController(){
        commandMap = new HashMap();

        commandMap.put("boardMain", new BoardCommandNull("boardMain.jsp"));
        commandMap.put("mainList", new BoardCommandList("mainList.jsp"));
        commandMap.put("boardView", new BoardCommandView("mvc_boardView.jsp"));

        // 글쓰기
        commandMap.put("insertBoard", new BoardCommandNull("mvc_boardInsertForm.jsp"));

        //글쓰기 성공하면 리스트로 돌아감
        commandMap.put("boardInsertOK", new BoardCommandInsert("mainList.jsp"));

        // 수정하기 눌렀을때 원래 글 목록 가져오기 위해 BoardCommandView와 연결
        commandMap.put("boardModify", new BoardCommandView("mvc_boardModifyForm.jsp"));
        commandMap.put("boardModifyOK", new BoardCommandModify("mvc_boardModify.jsp"));

        // 삭제
        commandMap.put("deleteBoard", new BoardCommandNull("mvc_boardDeleteForm.jsp"));
        commandMap.put("deleteBoardOK", new BoardCommandDelete("mvc_deleteConfirm.jsp"));

        // 답글
        commandMap.put("boardReply", new BoardCommandNull("mvc_boardReplyForm.jsp"));
        commandMap.put("boardReplyOK", new BoardCommandReply("mainList.jsp"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       processRequest(req, resp);
    }


    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String nextPage ="";
        String boardParam = request.getParameter("boardParam");

        if (boardParam == null) {
            boardParam="boardMain";
        }
        System.out.println("BoardController 53Line : " + boardParam);

        BoardCommand boardCommand = null;

        try{
            if (commandMap.containsKey(boardParam)) {
                boardCommand = (BoardCommand) commandMap.get(boardParam);
            }else{
                throw new BoardCommandException("지정할 명령어 존재 X");
            }
            nextPage = boardCommand.execute(request,response);

        }catch (BoardCommandException e){
            nextPage = error;
            System.out.println("BoardController 오류 : " + e.toString());
        }

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(jspDir+nextPage);
        requestDispatcher.forward(request,response);

    }
}
