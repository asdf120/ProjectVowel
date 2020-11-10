package movie.data;

import movie.data.vo.ReserveVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReserveDAO {
    Connection con;


    public ReserveDAO() throws Exception {
        this.con = DbSingleton.getInstance();
    }

    /**
     * 영화 예메 메소드
     */
    public void reserveMovie(ReserveVO reserveVo, String pay_sys) throws Exception {
        PreparedStatement st = null;

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd/ hh:mm:ss");
//        Date start_time = dateFormat.parse(reserveVo.getStart_time());
//        java.sql.Date sqlStart_time = new java.sql.Date(start_time.getTime());

        System.out.println("ReserveDao 26행 상영관번호: "+reserveVo.getTheater_no());
        System.out.println("회원번호 : " + reserveVo.getMember_tel());
        System.out.println(reserveVo.getStart_time());
        if (reserveVo.getNon_member_tel()==null) {// nonmember_tell이 null이면 회원의 전화번호값으로 쿼리실행
            if (reserveVo.getTheater_no().equals("1")) {
                String sql = "INSERT INTO reserve (reserve_no, member_tel, theater_no, start_time,seat_no,person_num,pay_sys,pay_money) VALUES (seq_reserve_no.NEXTVAL, ?, 2,to_date(?,'yy/mm/dd hh24:mi'),?,?,?,?) ";
//            String sql = "INSERT INTO reserve (reserve_no, member_tel, theater_no, start_time,seat_no,person_num,pay_sys,pay_money) VALUES (100, '010-9001-5568', 1,'20201110085500','C2',1,'카드',12000) ";
                st = con.prepareStatement(sql);
                System.out.println("ReserveDAO 값 확인");
                st.setString(1, reserveVo.getMember_tel()); // 회원전화번호
//            st.setString(2, reserveVo.getTheater_no()); // 상영관 번호
                //TODO 시간값 넣기
                st.setString(2, reserveVo.getStart_time());       // 시작시각
                st.setString(3, reserveVo.getSeat_no());    // 좌석번호
                st.setInt(4, reserveVo.getPerson_num());    // 관람인원
                st.setString(5, pay_sys);   // 결제 방식
                st.setInt(6, reserveVo.getPay_money()); // 결제금액
            }else{
                String sql = "INSERT INTO reserve (reserve_no, member_tel, theater_no, start_time,seat_no,person_num,pay_sys,pay_money) VALUES (seq_reserve_no.NEXTVAL, ?, 1,to_date(?,'yy/mm/dd hh24:mi'),?,?,?,?) ";
//            String sql = "INSERT INTO reserve (reserve_no, member_tel, theater_no, start_time,seat_no,person_num,pay_sys,pay_money) VALUES (100, '010-9001-5568', 1,'20201110085500','C2',1,'카드',12000) ";
                st = con.prepareStatement(sql);
                System.out.println("ReserveDAO 값 확인");
                st.setString(1, reserveVo.getMember_tel()); // 회원전화번호
//            st.setString(2, reserveVo.getTheater_no()); // 상영관 번호
                //TODO 시간값 넣기
                st.setString(2, reserveVo.getStart_time());       // 시작시각
                st.setString(3, reserveVo.getSeat_no());    // 좌석번호
                st.setInt(4, reserveVo.getPerson_num());    // 관람인원
                st.setString(5, pay_sys);   // 결제 방식
                st.setInt(6, reserveVo.getPay_money()); // 결제금액
            }
        } else {  // 비회원 예매
            if (reserveVo.getTheater_no().equals("1")) {
                String sql = "INSERT INTO reserve (reserve_no, non_member_tel, theater_no, start_time,seat_no,person_num,pay_sys,pay_money) VALUES (seq_reserve_no.NEXTVAL, ?, 2,to_date(?,'yy/mm/dd hh24:mi'),?,?,?,?) ";
//            String sql = "INSERT INTO reserve (reserve_no, member_tel, theater_no, start_time,seat_no,person_num,pay_sys,pay_money) VALUES (100, '010-9001-5568', 1,'20201110085500','C2',1,'카드',12000) ";
                st = con.prepareStatement(sql);
                System.out.println("ReserveDAO 값 확인");
                st.setString(1, reserveVo.getNon_member_tel()); // 비회원전화번호
//            st.setString(2, reserveVo.getTheater_no()); // 상영관 번호
                //TODO 시간값 넣기
                st.setString(2, reserveVo.getStart_time());       // 시작시각
                st.setString(3, reserveVo.getSeat_no());    // 좌석번호
                st.setInt(4, reserveVo.getPerson_num());    // 관람인원
                st.setString(5, pay_sys);   // 결제 방식
                st.setInt(6, reserveVo.getPay_money()); // 결제금액
            }else{
                String sql = "INSERT INTO reserve (reserve_no, non_member_tel, theater_no, start_time,seat_no,person_num,pay_sys,pay_money) VALUES (seq_reserve_no.NEXTVAL, ?, 1,to_date(?,'yy/mm/dd hh24:mi'),?,?,?,?) ";
//            String sql = "INSERT INTO reserve (reserve_no, member_tel, theater_no, start_time,seat_no,person_num,pay_sys,pay_money) VALUES (100, '010-9001-5568', 1,'20201110085500','C2',1,'카드',12000) ";
                st = con.prepareStatement(sql);
                System.out.println("ReserveDAO 값 확인");
                st.setString(1, reserveVo.getNon_member_tel()); // 비회원전화번호
//            st.setString(2, reserveVo.getTheater_no()); // 상영관 번호
                //TODO 시간값 넣기
                st.setString(2, reserveVo.getStart_time());       // 시작시각
                st.setString(3, reserveVo.getSeat_no());    // 좌석번호
                st.setInt(4, reserveVo.getPerson_num());    // 관람인원
                st.setString(5, pay_sys);   // 결제 방식
                st.setInt(6, reserveVo.getPay_money()); // 결제금액
            }
        }
        System.out.println("ReserveDao 58행");
        st.executeUpdate();
        System.out.println("예매 성공");
        st.close();
    }
}
