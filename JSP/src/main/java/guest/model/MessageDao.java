package guest.model;

import guest.vo.MessageVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageDao {

    // Single Pattern
    private static MessageDao instance;

    // DB 연결시  관한 변수
    private static final String dbDriver = "oracle.jdbc.driver.OracleDriver";
    private static final String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String dbUser = "kosmo_04";
    private static final String dbPass = "kosmo";

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //--------------------------------------------
    //#####	 객체 생성하는 메소드
    public static MessageDao getInstance() throws MessageException {
        if (instance == null) {
            instance = new MessageDao();
        }
        return instance;
    }

    private MessageDao() throws MessageException {

        try {
//				1. 드라이버를 로딩
            Class.forName(dbDriver);
        } catch (Exception ex) {
            throw new MessageException("방명록 ) DB 연결시 오류  : " + ex.toString());
        }

    }
    /*
     * 메세지를 입력하는 함수
     */
    public void insert(MessageVO messageVO) throws MessageException {
        try {
            // 1. 연결객체(Connection) 얻어오기
            con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
            // 2. sql 문장 만들기
            String sql = "INSERT INTO guestTB (message_id, guest_name,password,message) values (seq_guestTb_messageId.nextVal,?,?,?)";
            // 3. 전송객체 얻어오기
            ps = con.prepareStatement(sql);
            ps.setString(1,messageVO.getGuestName());
            ps.setString(2,messageVO.getPassword());
            ps.setString(3,messageVO.getMessage());
            // 4. 전송하기
            ps.executeUpdate();
        } catch (Exception ex) {
            throw new MessageException("방명록 ) DB에 입력시 오류  : " + ex.toString());
        } finally {
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

    /*
     * 메세지 목록 전체를 얻어올 때
     */
//    public List<MessageVO> selectList() throws MessageException {
//        List<MessageVO> mList = new ArrayList<MessageVO>();
//        boolean isEmpty = true;
//        try {
//            con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
//            String sql = "SELECT * FROM guestTB";
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                MessageVO messageVo = new MessageVO();
//                messageVo.setId(rs.getInt("MESSAGE_ID"));
//                messageVo.setGuestName(rs.getString("GUEST_NAME"));
//                messageVo.setMessage(rs.getString("MESSAGE"));
//                mList.add(messageVo);
//                isEmpty = false;
//            }
//            if (isEmpty) return Collections.emptyList();
//            return mList;
//        } catch (Exception ex) {
//            throw new MessageException("방명록 ) DB에 목록 검색시 오류  : " + ex.toString());
//        } finally {
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException ex) {
//                }
//            }
//            if (ps != null) {
//                try {
//                    ps.close();
//                } catch (SQLException ex) {
//                }
//            }
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                }
//            }
//        }
//    }
    /* -------------------------------------------------------
     * 현재 페이지에 보여울 메세지 목록  얻어올 때
     */
    public List<MessageVO> selectList(int firstRow, int endRow) throws MessageException {
        List<MessageVO> mList = new ArrayList<>();
        boolean isEmpty = true;
        try {
            con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
            String sql = "select *\n" +
                    "from guesttb\n" +
                    "where message_id IN (select message_id\n" +
                    "                from (select rownum as rnum ,message_id\n" +
                    "                            from (select message_id from guesttb\n" +
                    "                order by message_id desc))\n" +
                    "                where rnum>=? and rnum<=?)\n" +
                    "order by message_id desc";

            ps = con.prepareStatement(sql);
            ps.setInt(1,firstRow);
            ps.setInt(2,endRow);
            rs = ps.executeQuery();
            while (rs.next()) {
                MessageVO messageVo = new MessageVO();
                messageVo.setId(rs.getInt("MESSAGE_ID"));
                messageVo.setGuestName(rs.getString("GUEST_NAME"));
                messageVo.setMessage(rs.getString("MESSAGE"));
                mList.add(messageVo);
                isEmpty = false;
            }
            if (isEmpty) return Collections.emptyList();

            return mList;
        } catch (Exception ex) {
            throw new MessageException("방명록 ) DB에 목록 검색시 오류  : " + ex.toString());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
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



    /* -------------------------------------------------------
     * 메세지 전체 레코드 수를 검색
     */

    public int getTotalCount() throws MessageException {
        int count = 0;

        try {
            con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
            String sql = "SELECT count(*) totalCount FROM guestTB";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            //
            rs.next();
            count = rs.getInt("totalCount");
            return count;

        } catch (Exception ex) {
            throw new MessageException("방명록 ) DB에 목록 검색시 오류  : " + ex.toString());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
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

    /*
     * 메세지 번호와 비밀번호에 의해 메세지 삭제
     */
    public int delete(int messageId, String password) throws MessageException {
        int result = 0; // 0 => 삭제할 메시지가 없음
        System.out.println("mDao 205 line:"+ messageId);
        try {
            con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
            String findMessage = "SELECT * FROM guestTB where message_id = ? and password = ?";
            PreparedStatement findMsg = con.prepareStatement(findMessage);
            findMsg.setInt(1,messageId);
            findMsg.setString(2,password);
            rs = findMsg.executeQuery();
            if (rs.next()) {    // 없으면 result = 0 ==> 삭제 불가
                String sql = "DELETE FROM guestTB WHERE message_id = ? and password = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1,messageId);
                ps.setString(2,password);

                ps.executeUpdate();
                result = 1;
            }else{
                result = 0;
            }
            System.out.println("mDao 224 line:"+ result);
            findMsg.close();

            return result;
        } catch (Exception ex) {
            throw new MessageException("방명록 ) DB에 삭제시 오류  : " + ex.toString());
        } finally {
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
}
