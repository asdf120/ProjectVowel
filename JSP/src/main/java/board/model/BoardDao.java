package board.model;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardDao {

    // Single Pattern
    private static BoardDao instance;

    // DB 연결시  관한 변수
    private static final String dbDriver = "oracle.jdbc.driver.OracleDriver";
    private static final String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String dbUser = "kosmo_04";
    private static final String dbPass = "kosmo";

    PreparedStatement ps = null;
    ResultSet rs = null;
    Statement stmt = null;
    private Connection con;

    //--------------------------------------------
    //#####	 객체 생성하는 메소드
    public static BoardDao getInstance() throws BoardException {
        if (instance == null) {
            instance = new BoardDao();
        }
        return instance;
    }

    private BoardDao() throws BoardException {

        try {

            /********************************************
             1. 오라클 드라이버를 로딩
             ( DBCP 연결하면 삭제할 부분 )
             */
            Class.forName(dbDriver);

        } catch (Exception ex) {
            throw new BoardException("DB 연결시 오류  : " + ex.toString());
        }

    }


    //--------------------------------------------
    //#####	 게시글 입력전에 그 글의 그룹번호를 얻어온다
    public int getGroupId() throws BoardException {
        ps = null;
        rs = null;
        int groupId = 1;
        try {
            con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            String sql = "SELECT SEQ_GROUP_ID_ARTICLE.nextval as groupNo FROM dual";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                groupId = rs.getInt("groupNo");
            }
            return groupId;
        } catch (Exception ex) {
            throw new BoardException("게시판 ) 게시글 입력 전에 그룹번호 얻어올 때  : " + ex.toString());
        } finally {
            allClose();
        }
    }

    //--------------------------------------------
    //#####	 게시판에 글을 입력시 DB에 저장하는 메소드
    public int insert(BoardVO boardVo) throws BoardException {
        rs = null;
        stmt = null;
        ps = null;
        try {
            con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            String sql = "INSERT INTO article VALUES (seq_article_id_article.nextval, ?,?,sysdate,0,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, boardVo.getGroupId());
            ps.setString(2, boardVo.getSequenceNo());
            ps.setString(3, boardVo.getWriterName());
            ps.setString(4, boardVo.getPassword());
            ps.setString(5, boardVo.getTitle());
            ps.setString(6, boardVo.getContent());

            ps.executeUpdate();

            stmt = con.createStatement();
            // 시퀀스값을 얻어올 sql 생성
            String sqlSeq = "SELECT seq_article_id_article.currval AS articleId FROM dual";
            rs = stmt.executeQuery(sqlSeq);
            if (rs.next()) {
                System.out.println("BoardDao 96line : " + rs.getInt("articleId"));
                return rs.getInt("articleId");
            }

            return -1;

        } catch (Exception ex) {
            throw new BoardException("게시판 ) DB에 입력시 오류  : " + ex.toString());
        } finally {
            allClose();
        }

    }

    //--------------------------------------------
    //#####	 전체 레코드를 검색하는 함수
    // 리스트에 보여줄거나 필요한 컬럼 : 게시글번호, 그룹번호, 순서번호, 게시글등록일시, 조회수, 작성자이름,  제목
    //							( 내용, 비밀번호  제외 )
    // 순서번호(sequence_no)로 역순정렬
//    public List<BoardVO> selectList() throws BoardException {
//        ps = null;
//        rs = null;
//        List<BoardVO> mList = new ArrayList<>();
//        boolean isEmpty = true;
//
//        try {
//            con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
//            String sql = "SELECT article_id,group_id,sequence_no,posting_date,read_count,writer_name,title " +
//                    " from article " +
//                    " order by sequence_no desc";
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while(rs.next()) {
//                BoardVO boardVO = new BoardVO();
//                boardVO.setArticleId(rs.getInt("article_id"));
//                boardVO.setGroupId(rs.getInt("group_id"));
//                boardVO.setSequenceNo(rs.getString("sequence_no"));
//                boardVO.setPostingDate(rs.getString("posting_date"));
//                boardVO.setReadCount(rs.getInt("read_count"));
//                boardVO.setWriterName(rs.getString("writer_name"));
//                boardVO.setTitle(rs.getString("title"));
//                mList.add(boardVO);
//                isEmpty = false;
//            }
//
//            if (isEmpty) return Collections.emptyList();
//
//            return mList;
//        } catch (Exception ex) {
//            throw new BoardException("게시판 ) DB에 목록 검색시 오류  : " + ex.toString());
//        } finally {
//            allClose();
//        }
//    }

    public List<BoardVO> selectList(int firstRow, int endRow) throws BoardException {
        ps = null;
        rs = null;
        List<BoardVO> mList = new ArrayList<>();
        boolean isEmpty = true;

        try {
            con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            String sql = "select *\n" +
                    "from article\n" +
                    "where article_id IN (select article_id\n" +
                    "                from (select rownum as rnum ,article_id\n" +
                    "                            from (select article_id from article\n" +
                    "                order by article_id desc))\n" +
                    "                where rnum>=? and rnum<=?)\n" +
                    "order by article_id desc";
            ps = con.prepareStatement(sql);
            ps.setInt(1, firstRow);
            ps.setInt(2, endRow);

            rs = ps.executeQuery();
            while (rs.next()) {
                BoardVO boardVO = new BoardVO();
                boardVO.setArticleId(rs.getInt("article_id"));
                boardVO.setGroupId(rs.getInt("group_id"));
                boardVO.setSequenceNo(rs.getString("sequence_no"));
                boardVO.setPostingDate(rs.getString("posting_date"));
                boardVO.setReadCount(rs.getInt("read_count"));
                boardVO.setWriterName(rs.getString("writer_name"));
                boardVO.setTitle(rs.getString("title"));
                mList.add(boardVO);
                isEmpty = false;
            }

            if (isEmpty) return Collections.emptyList();

            return mList;
        } catch (Exception ex) {
            throw new BoardException("게시판 ) DB에 목록 검색시 오류  : " + ex.toString());
        } finally {
            allClose();
        }
    }

    public int getTotalCount() throws BoardException {
        int count = 0;

        try {
            con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            String sql = "Select count(*) as totalCount FROM article";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            count = rs.getInt("totalCount");

            return count;

        } catch (Exception e) {
            throw new BoardException("게시판 ) DB 페이징 처리 오류 : " + e.toString());
        } finally {
            allClose();
        }

    }

    //--------------------------------------------
    //#####	 게시글번호에 의한 레코드 검색하는 함수
    // 			비밀번호 제외하고 모든 컬럼 검색
    public BoardVO selectById(int id) throws BoardException {
        ps = null;
        rs = null;

        BoardVO boardVO = new BoardVO();
        try {
            con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            String sql = "SELECT * FROM article where article_id = ?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                boardVO.setArticleId(rs.getInt("article_id"));
                boardVO.setGroupId(rs.getInt("group_id"));
                boardVO.setSequenceNo(rs.getString("SEQUENCE_NO"));
                boardVO.setPostingDate(rs.getString("posting_date"));
                boardVO.setReadCount(rs.getInt("read_count"));
                boardVO.setWriterName(rs.getString("WRITER_NAME"));
                boardVO.setTitle(rs.getString("TITLE"));
                boardVO.setContent(rs.getString("CONTENT"));
            }

            return boardVO;
        } catch (Exception ex) {
            throw new BoardException("게시판 ) DB에 글번호에 의한 레코드 검색시 오류  : " + ex.toString());
        } finally {
            allClose();
        }
    }

    //--------------------------------------------
    //#####	 게시글 보여줄 때 조회수 1 증가
    public void increaseReadCount(int article_id) throws BoardException {

        ps = null;
        try {
            con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            String sql = "UPDATE article SET read_count =read_count+1 WHERE article_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, article_id);
            ps.executeUpdate();

        } catch (Exception ex) {
            throw new BoardException("게시판 ) 게시글 볼 때 조회수 증가시 오류  : " + ex.toString());
        } finally {
            allClose();
        }

    }

    //--------------------------------------------
    //#####	 게시글 수정할 때
    //		( 게시글번호와 패스워드에 의해 수정 )
    public int update(BoardVO boardVo) throws BoardException {
        ps = null;
        rs = null;
        int result = 0;
        try {
            con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            String modifySql = "UPDATE article SET title = ?, posting_date=sysdate, content = ? where article_id = ? and password = ?";
            ps = con.prepareStatement(modifySql);
            ps.setString(1, boardVo.getTitle());
            ps.setString(2, boardVo.getContent());
            ps.setInt(3, boardVo.getArticleId());
            ps.setString(4, boardVo.getPassword());
            result = ps.executeUpdate();

            return result; // 나중에 수정된 수를 리턴하시오.

        } catch (Exception ex) {
            throw new BoardException("게시판 ) 게시글 수정시 오류  : " + ex.toString());
        } finally {
            allClose();
        }

    }


    //--------------------------------------------
    //#####	 게시글 삭제할 때
    //		( 게시글번호와 패스워드에 의해 삭제 )
    public int delete(int article_id, String password) throws BoardException {
        ps = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            String findSql = "Select * FROM article WHERE article_id = ? and password = ?";
            preparedStatement = con.prepareStatement(findSql);
            preparedStatement.setInt(1, article_id);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String delSql = "DELETE FROM article where article_id = ? and password = ?";
                ps = con.prepareStatement(delSql);
                ps.setInt(1, article_id);
                ps.setString(2, password);
                ps.executeUpdate();
                return 1;
            }

            return 0; // 나중에 수정된 수를 리턴하시오.

        } catch (Exception ex) {
            throw new BoardException("게시판 ) 게시글 수정시 오류  : " + ex.toString());
        } finally {
            allClose();
            try {
                preparedStatement.close();
            } catch (Exception e) {
                e.toString();
            }
        }

    }


    //----------------------------------------------------
    //#####  부모레코드의 자식레코드 중 마지막 레코드의 순서번호를 검색
    //       ( 제일 작은 번호값이 마지막값임)
    public String selectLastSequenceNumber(String maxSeqNum, String minSeqNum) throws BoardException {
        ps = null;
        rs = null;

        try {
            con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            String sql = "SELECT min(sequence_no) as minseq FROM article WHERE sequence_no < ? AND sequence_no >= ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, maxSeqNum);
            ps.setString(2, minSeqNum);
            rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }

            return rs.getString("minseq");
        } catch (Exception ex) {
            throw new BoardException("게시판 ) 부모와 연관된 자식 레코드 중 마지막 순서번호 얻어오기  : " + ex.toString());
        } finally {
            allClose();
        }
    }

    //TODO close()메소드 처리해주기
    public void allClose() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
            }
        }
    }
}