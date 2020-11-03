package videoshop.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import videoshop.model.vo.CustomerVO;


public class CustomerDAO {
    CustomerVO vo;
    Connection con;

    //  constructor
    public CustomerDAO() throws Exception {
        connectDB();
    }

    //###########################################################
    //	DB  control method
    void connectDB() throws Exception {
//						1. 드라이버를 드라이버메니저에 등록
//						2. 연결 객체 얻어오기
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.57:1521:orcl", "team10", "team10");
    }


    public void regist(CustomerVO customerVO) throws Exception {
//						1.  sql 작성하기		( insert 문 작성 : CustomerVO의 멤버변수로 각각 지정하여 )
        String sql = "INSERT INTO member (name,tel,extra_tel,address,email) values (?,?,?,?,?)";
//						2.  sql  전송객체 얻어오기	( PreparedStatement가 더 적합할 듯 )
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, customerVO.getName());
        statement.setString(2, customerVO.getTel());
        statement.setString(3, customerVO.getExtra_tel());
        statement.setString(4, customerVO.getAddress());
        statement.setString(5, customerVO.getEmail());
//						3.  sql  전송			( 전송전에 ?로 지정 )
        statement.executeUpdate();
//						4.  닫기				( Connection은 닫으면 안됨 )
        statement.close();
    }

    public int modify(CustomerVO customerVO) throws Exception {
//						1.  sql 작성하기		( update 문 작성 : CustomerVO의 멤버변수로 각각 지정하여 )
        String sql = "UPDATE member SET name = ? , extra_tel = ?, address = ? , email = ? where tel = ?";
//						2.  sql  전송객체 얻어오기	( PreparedStatement가 더 적합할 듯 )
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, customerVO.getName());
        statement.setString(2, customerVO.getExtra_tel());
        statement.setString(3, customerVO.getAddress());
        statement.setString(4, customerVO.getEmail());
        statement.setString(5, customerVO.getTel());
//						3.  sql  전송			( 전송전에 ?로 지정 )
        int result = statement.executeUpdate();
        if (result == 0) {
            return -1;
        }
//						4.  닫기				( Connection은 닫으면 안됨 )
        statement.close();
        return 0;
    }


    public ArrayList searchName(String name) throws Exception {
        ArrayList<CustomerVO> memberList = new ArrayList();
//			1.  sql 작성하기	 ( select 문 : 함수의 인자로 넘어온 이름과 같은 조건의 레코드 검색 )
        String sql = "SELECT * FROM member WHERE name = ?";
//			2.  sql  전송객체 얻어오기	( Statement / PreparedStatement 모두 적합 )
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1,name);
//			3.  sql  전송		 ( ResultSet 의 데이타를 얻어서 멤버 필드에 지정 )
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            vo = new CustomerVO();
            vo.setName(resultSet.getString("NAME"));
            vo.setTel(resultSet.getString("TEL"));
            vo.setExtra_tel(resultSet.getString("EXTRA_TEL"));
            vo.setAddress(resultSet.getString("ADDRESS"));
            vo.setEmail(resultSet.getString("EMAIL"));

            memberList.add(vo); // 리스트에 멤버 정보 추가
        }
//						4.  닫기			 ( Connection은 닫으면 안됨 )
            statement.close();
//						#   생각해 보기
//							- 동명 이인이 여러명 인 경우는 어떻게 처리할까?

        return memberList;
    }


    public CustomerVO searchTel(String tel) throws Exception {
        vo = new CustomerVO();

//		1.  sql 작성하기	 ( select 문 : 함수의 인자로 넘어온 전화번호과 같은 조건의 레코드 검색 )
        String sql = "SELECT * FROM member WHERE tel = ?";
//		2.  sql  전송객체 얻어오기	( Statement / PreparedStatement 모두 적합 )
        PreparedStatement statement = con.prepareStatement(sql);
//		3.  sql  전송		 ( ResultSet 의 데이타를 얻어서 멤버 필드에 지정 )
        statement.setString(1, tel);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            vo.setName(resultSet.getString("NAME"));
            vo.setTel(resultSet.getString("TEL"));
            vo.setExtra_tel(resultSet.getString("EXTRA_TEL"));
            vo.setAddress(resultSet.getString("ADDRESS"));
            vo.setEmail(resultSet.getString("EMAIL"));
        }else{
            vo = null;
        }
//						4.  닫기			 ( Connection은 닫으면 안됨 )
        statement.close();
        return vo;
    }
}
