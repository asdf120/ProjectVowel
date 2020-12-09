package mvc_board.command;

import mvc_board.model.BoardDao;
import mvc_board.model.BoardException;
import mvc_board.model.BoardVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.util.List;

public class BoardCommandReply implements BoardCommand {
    String next = "";

    public BoardCommandReply(String next) {
        this.next = next;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws BoardCommandException {
        System.out.println("BoardCommandReply 20Line : " + next);
        try {
            BoardVO boardVo = new BoardVO();
            boardVo.setWriterName(request.getParameter("writerName"));
            boardVo.setTitle(request.getParameter("title"));
            boardVo.setContent(request.getParameter("content"));
            boardVo.setPassword(request.getParameter("password"));
            String pId = request.getParameter("articleId");

            int parentId = 0;
            if (pId != null) parentId = Integer.parseInt(pId);


            BoardDao dao = BoardDao.getInstance();
            // 부모게시글의 레코드를 얻어옴
            BoardVO parent = dao.selectById(parentId);

            // 부모게시글을 체크
            checkParent(parent, parentId);

            // 답변글에 순서번호 구하기
            String maxSeqNum = parent.getSequenceNo();
            String minSeqNum = getSearchMinSeqNum(parent);

            String lastChildSeq = dao.selectLastSequenceNumber(maxSeqNum, minSeqNum);

            String sequenceNumber = getSequenceNumber(parent, lastChildSeq);


            boardVo.setGroupId(parent.getGroupId()); // 부모의 그룹번호와 동일하게 지정
            boardVo.setSequenceNo(sequenceNumber);     // 위에서 구한 답변글의 순서번호 지정
//		boardVo.setPostingDate( (new Date()).toString());	 // 등록일

            int articleId = dao.insert(boardVo);
            boardVo.setArticleId(articleId);

            List<BoardVO> mList = BoardDao.getInstance().selectList();
            request.setAttribute("mList", mList );

        } catch (Exception e) {
            throw new BoardCommandException("BoardCommendReply 오류 : " + e.toString());
        }

        return next;
    }

    private void checkParent(BoardVO parent, int pId) throws BoardException {

        if (parent == null) throw new BoardException("부모글이 존재하지 않음 : " + pId);

        int parentLevel = parent.getLevel();
        if (parentLevel == 3) throw new BoardException("3단계 마지막 레벨 글에는 답변을 달 수 없습니다.");

    }


    private String getSearchMinSeqNum(BoardVO parent) {
        String parentSeqNum = parent.getSequenceNo();
        DecimalFormat dFormat = new DecimalFormat("0000000000000000");
        long parentSeqLongValue = Long.parseLong(parentSeqNum);
        long searchMinLongValue = 0;

        switch (parent.getLevel()) {
            case 0:
                searchMinLongValue = parentSeqLongValue / 1000000L * 1000000L;
                break;
            case 1:
                searchMinLongValue = parentSeqLongValue / 10000L * 10000L;
                break;
            case 2:
                searchMinLongValue = parentSeqLongValue / 100L * 100L;
                break;
        }
        return dFormat.format(searchMinLongValue);
    }


    private String getSequenceNumber(BoardVO parent, String lastChildSeq) throws BoardException {
        long parentSeqLong = Long.parseLong(parent.getSequenceNo());
        int parentLevel = parent.getLevel();

        long decUnit = 0;
        if (parentLevel == 0) {
            decUnit = 10000L;
        } else if (parentLevel == 1) {
            decUnit = 100L;
        } else if (parentLevel == 2) {
            decUnit = 1L;
        }

        String sequenceNumber = null;

        DecimalFormat dFormat = new DecimalFormat("0000000000000000");
        if (lastChildSeq == null) {            // 답변글이 없다면
            sequenceNumber = dFormat.format(parentSeqLong - decUnit);
        } else {                            // 답변글이 있다면, 마지막 답변글인지 확인
            String orderOfLastChildSeq = null;
            if (parentLevel == 0) {
                orderOfLastChildSeq = lastChildSeq.substring(10, 12);
                sequenceNumber = lastChildSeq.substring(0, 12) + "9999";
            } else if (parentLevel == 1) {
                orderOfLastChildSeq = lastChildSeq.substring(12, 14);
                sequenceNumber = lastChildSeq.substring(0, 14) + "99";
            } else if (parentLevel == 2) {
                orderOfLastChildSeq = lastChildSeq.substring(14, 16);
                sequenceNumber = lastChildSeq;
            }

            if (orderOfLastChildSeq.equals("00")) {
                throw new BoardException("마지막 자식 글이 이미 존재합니다.");
            }

            long seq = Long.parseLong(sequenceNumber) - decUnit;
            sequenceNumber = dFormat.format(seq);

            return sequenceNumber;
        }
        return sequenceNumber;

    }
}
