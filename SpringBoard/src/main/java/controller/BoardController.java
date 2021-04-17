package controller;

import domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BoardService;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/getBoardList.do")
    public String boardList(BoardVO boardVO, Model model){
        // BoardVO boardVO 현재는 필요 X
        System.out.println("boardList");
        List<BoardVO> boardList = boardService.getBoardList(boardVO);
        // Map 이용
//        Map map =new HashMap();
//        map.put("boardList", boardList);

        // Model이용
        model.addAttribute("boardList", boardList);
        return "getBoardList";
    }

    @RequestMapping("/getBoard.do")
    public String getBoard(BoardVO boardVO,Model model){
        System.out.println("board");

        model.addAttribute("board",boardService.getBoard(boardVO));

        return "getBoard";
    }

    // 글쓰기 페이지로 이동
    // {변수}.url ==> 해당하는 요청 페이지가 없으면 이 메소드를 찾아서
    // 요청페이지로 이동
    @RequestMapping("/insertBoard.do")    // step ==> 변수
    public String insertBoard(){
        return "insertBoard";
    }

    // 글 입력
    @RequestMapping("saveBoard.do")
    public String saveBoard(BoardVO boardVO){
        boardService.insertBoard(boardVO);

        return "redirect:/getBoardList.do";
    }

    // 수정
    @RequestMapping("updateBoard.do")
    public String updateBoard(BoardVO boardVO,Model model){
        boardService.updateBoard(boardVO);

        return "redirect:/getBoard.do?seq="+boardVO.getSeq();
    }
}
