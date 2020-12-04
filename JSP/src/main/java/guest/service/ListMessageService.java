package guest.service;

import guest.model.MessageDao;
import guest.model.MessageException;
import guest.vo.MessageVO;

import java.util.List;

public class ListMessageService {

    //-------------------------------------------------------------------
    /**
     * 여기 추가
     */
    private int totalRecCount;        // 전체 레코드 수
    private int pageTotalCount;        // 전체 페이지 수
    private int countPerPage = 3;    // 한페이지당 레코드 수

    private static ListMessageService instance;

    public static ListMessageService getInstance() throws MessageException {
        if (instance == null) {
            instance = new ListMessageService();
        }
        return instance;
    }

    private ListMessageService() {

    }

    /**
     * 여기추가
     */
    public List<MessageVO> getMessageList(int pageNo) throws MessageException {

        // 해당 페이지 레코드를 검색해 온다면
        /** 페이지번호 시작레코드번호 끝레코드번호 (페이지당 3개 보여준다면)
         *      1       1           3
         *      2       4           6
         *      3       7           9
         *      4       10          12
         */
        int firstRow = (pageNo*countPerPage)-2;
        int endRow = pageNo*countPerPage;
        List<MessageVO> mList = MessageDao.getInstance().selectList(firstRow,endRow);
        return mList;
    }

    /**
     * 전체 메시지 레코드 수 얻어오기
     */
    public int getTotalPage() throws MessageException {
		totalRecCount = MessageDao.getInstance().getTotalCount();
        if (totalRecCount % countPerPage == 0) {
            pageTotalCount = totalRecCount / countPerPage;
        }else{
            pageTotalCount = (totalRecCount/countPerPage) + 1;
        }
		return pageTotalCount;
    }
}
