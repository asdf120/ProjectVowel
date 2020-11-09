package movie.data;

import movie.data.vo.ReserveVO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReserveDAO {
    Connection con;

    public ReserveDAO() throws Exception{
        this.con = DbSingleton.getInstance();
    }

    public void reserve(ReserveVO reserveVo,String pay_sys)throws Exception{
        PreparedStatement st = null;
        if(reserveVo.getNon_member_tel().equals(null)){ // nonmember_tell이 null이면 회원의 전화번호값으로 쿼리실행
            String sql = "UPDATE reserve SET reserve_no = reserve_no.NEXTVAL member_tel = ?, theater_no = ?, start_time = ?, seat_no = ?, person_num = ?, " +
                    " pay_sys = ?, pay_money = ? where member_tel = ?";
            st = con.prepareStatement(sql);
            st.setString(1,reserveVo.getMember_tel());
            st.setString(2,reserveVo.getTheater_no());
            //TODO 시간값 넣기
//        st.setDate(3,reserveVo.getStart_time());
            st.setString(4,reserveVo.getSeat_no());
            st.setInt(5,reserveVo.getPerson_num());
            st.setString(6,pay_sys);
            st.setInt(7,reserveVo.getPay_money());
            st.setString(8,reserveVo.getMember_tel());
        }else{  // 비회원 예매
            String sql = "UPDATE reserve SET reserve_no = reserve_no.NEXTVAL, nonmember_tel = ?, theater_no = ?, start_time = ?, seat_no = ?, person_num = ?, " +
                    " pay_sys = ?, pay_money = ? where nonmember_tel = ?";
            st = con.prepareStatement(sql);

            st.setString(1,reserveVo.getNon_member_tel());
            st.setString(2,reserveVo.getTheater_no());
//        st.setDate(3,reserveVo.getStart_time());
            st.setString(4,reserveVo.getSeat_no());
            st.setInt(5,reserveVo.getPerson_num());
            st.setString(6,pay_sys);
            st.setInt(7,reserveVo.getPay_money());
            st.setString(8,reserveVo.getNon_member_tel());
        }
        st.executeUpdate();

        st.close();
    }
}
