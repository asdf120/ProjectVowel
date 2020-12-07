package board.service;

import java.util.List;

import board.model.BoardDao;
import board.model.BoardException;
import board.model.BoardVO;

public class ListArticleService {
    private static ListArticleService instance;

    private int totalRecCount;        // 전체 레코드 수
    private int pageTotalCount;        // 전체 페이지 수
    private int countPerPage = 3;    // 한페이지당 레코드 수

    public static ListArticleService getInstance() throws BoardException {
        if (instance == null) {
            instance = new ListArticleService();
        }
        return instance;
    }

//    public List<BoardVO> getArticleList() throws BoardException {
//        //
//        List<BoardVO> mList = BoardDao.getInstance().selectList();
//        return mList;
//    }

    public List<BoardVO> getArticleList(int pageNo) throws BoardException {
        int firstRow = (pageNo*countPerPage)-2;
        int endRow = pageNo*countPerPage;

        List<BoardVO> mList = BoardDao.getInstance().selectList(firstRow,endRow);
        return mList;
    }

    public int getTotalPage() throws BoardException{
        totalRecCount = BoardDao.getInstance().getTotalCount();

        if (totalRecCount % countPerPage == 0) {
            pageTotalCount = totalRecCount / countPerPage;
        }else{
            pageTotalCount = (totalRecCount/countPerPage) + 1;
        }
        return pageTotalCount;
    }
}
