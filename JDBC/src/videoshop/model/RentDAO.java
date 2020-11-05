package videoshop.model;

import movie.data.vo.MemberVO;

import java.sql.*;
import java.util.ArrayList;

public class RentDAO {
    Connection con;

    public RentDAO() throws Exception{
        con = DBCon.getInstance();
    }

    public void rent(String tel, String vNum) throws Exception{
        String sql = "INSERT INTO rent(rent_no, tel, video_no, rent_date)" +
                " VALUES(seq_rent_no.nextval, ?, ?, sysdate)";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1,tel);
        statement.setString(2,vNum);

        statement.executeUpdate();

        statement.close();
        System.out.println("RentDAO 대여 완료");
    }

    public String searchName(String tel) throws Exception{
        MemberVO memberVO = new MemberVO();

        String sql = "SELECT name FROM member WHERE tel = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1,tel);

        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getString("NAME");
        }
        return null;
    }

    public void searchRentVideo(int vNum)throws Exception{
        String sql = "UPDATE rent SET return_date = sysdate where video_no = ? AND return_date is null";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1,vNum);

        statement.executeUpdate();
        statement.close();
        System.out.println("반납완료");
    }

    public ArrayList select() throws Exception{
        ArrayList data = new ArrayList();

        String sql = "SELECT v.video_no VIDEO_NO, v.title TITLE, m.name NAME, m.tel TEL,(r.rent_date+3) preturn_date, '미납' " +
                " from member m, rent r, video v " +
                " where r.tel = m.tel and r.video_no = v.video_no AND return_date is null";
        System.out.println(sql);

        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            ArrayList temp = new ArrayList();
            temp.add(resultSet.getInt("VIDEO_NO"));
            temp.add(resultSet.getString("TITLE"));
            temp.add(resultSet.getString("NAME"));
            temp.add(resultSet.getString("TEL"));
            temp.add(resultSet.getString("preturn_date"));
            temp.add(resultSet.getString("'미납'"));
            data.add(temp);
        }
        return data;
    }

}
