package movie.data;

import movie.data.vo.ManagerVO;
import movie.data.vo.MemberVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class AdminDAO {
	
	Connection	con;

	//constructor
	public AdminDAO() throws Exception{
		con = DbSingleton.getInstance();
	}
	
	// ########## A_MemberView ############
	
	/**
	 *  역할 : 받아온 아이디와 DB에 저장된 아이디와 비교하여  사용가능한 아이디면 0, 이미 존재하는 아이디면 -1 리턴
	 */
	public int idConfirm(String id) throws Exception{
		String sql = "SELECT member_id FROM member WHERE member_id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			rs.close();
			st.close();
			return -1;
		}else {
			rs.close();
			st.close();
			return 0;
		} 
		
	}
	
	/**
	 *  역할 : 받아온 전화번호와 DB에 저장된 아이디와 비교하여  사용가능한 전화번호면 0, 이미 존재하는 전화번호면 -1 리턴
	 */
	public int telConfirm(String tel) throws Exception{
		String sql = "SELECT tel FROM member WHERE tel=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, tel);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			rs.getString("tel");
			rs.close();
			st.close();
			return -1;
		}else {
			rs.close();
			st.close();
			return 0;
		} 
		
	}
	
	
	/**
	 *  역할 : 받아온 값을  DB member테이블에 저장
	 */
	public void regist(MemberVO mem) throws Exception{
		String sql = "INSERT INTO member(tel,member_id,password, name, birth, email)VALUES (?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, mem.getTel());
		st.setString(2, mem.getMember_id());
		st.setString(3, mem.getPassword());
		st.setString(4, mem.getName());
		st.setDate(5, mem.getBirth());
		st.setString(6, mem.getEmail());
		st.executeUpdate();
		st.close();
		
	}
		
	/**
	 *  역할 : 회원 검색 시 콤보박스 인덱스와 검색키워드 값 가져와서 DB와 비교하여 해당하는 데이터 ArrayList 타입으로 리턴
	 */
	public ArrayList searchMember(int idx, String word) throws Exception{
		String [] colName = {"name","tel","member_id","birth"}; //int idx가 0이면 이름으로 검색, 1이면 전화번호,2면 아이디로 검색
		String sql = "SELECT member_id,name,tel,to_char(birth,'YYYY/MM/DD') birth FROM member WHERE "+colName[idx]+" LIKE '%"+word+"%'";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ArrayList data = new ArrayList();
		while(rs.next()){
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("member_id"));
			temp.add(rs.getString("name"));
			temp.add(rs.getString("tel"));
			temp.add(rs.getString("birth"));
			data.add(temp); // arraylist 타입의 2차원 배열
		}
		rs.close();
		st.close();
		return data;
	}
	
	/**
	 *  역할 : 회원 검색 시 콤보박스 인덱스가 '생년월일'일 경우 검색키워드 값 가져와서 DB와 비교하여 해당하는 데이터 ArrayList 타입으로 리턴
	 */
	public ArrayList searchMember1(int idx, String word) throws Exception{
		String sql = "SELECT member_id,name,tel,to_char(birth,'YYYY/MM/DD') birth FROM member WHERE birth = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, word);
		ResultSet rs = st.executeQuery();
		ArrayList data = new ArrayList();
		while(rs.next()){
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("member_id"));
			temp.add(rs.getString("name"));
			temp.add(rs.getString("tel"));
			temp.add(rs.getString("birth"));
			data.add(temp); // arraylist 타입의 2차원 배열
		}
		rs.close();
		st.close();
		return data;
	}
	/**
	 *  역할 : 가져온 아이디 값에 해당하는 회원정보를  MemberVO에 담아서 리턴
	 */
	public MemberVO searchByID(String id) throws Exception{
		MemberVO vo = new MemberVO();
		
		String sql = "SELECT * FROM member WHERE member_id = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			vo.setTel(rs.getString("tel"));
			vo.setBirth(rs.getDate("birth"));
			vo.setEmail(rs.getString("email"));
			vo.setMember_id(rs.getString("member_id"));
			vo.setName(rs.getString("name"));
			vo.setPassword(rs.getString("password"));
		}
		rs.close();
		st.close();
		
		return vo;
	}
	
	/**
	 *  역할 : 가져온 값과 DB의 값 비교하여 일치하는 곳 레코드를 업데이트
	 */
	public void modifyMember(MemberVO vo) throws Exception{
		String sql = "UPDATE member SET member_id=?,password=?,name=?,birth=?,email=?   "
				+ "WHERE tel =?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, vo.getMember_id());
		st.setString(2, vo.getPassword());
		st.setString(3, vo.getName());
		st.setDate(4, vo.getBirth());
		st.setString(5, vo.getEmail());
		st.setString(6, vo.getTel());
		st.executeQuery();
		
		st.close();
	}
	
	/**
	 *  역할 : 가져온 전화번호와 일치하는 레코드 찾아 DB에서  DELETE
	 */
	public void deleteMember(String tel) throws Exception{
		String sql ="DELETE FROM member WHERE tel =?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, tel);
		st.close();
	}
	
	/**
	 *  역할 : Reserve 테이블의 예매번호와 가져온 예매번호를 비교하여 일치하는 레코드를 ReserveVO 타입으로 리턴
	 */
	public ArrayList searchReserve(String rNum) throws Exception{
		ArrayList list = new ArrayList();
		String sql = "SELECT reserve_no,theater_no,seat_no,person_num,pay_sys,pay_money FROM reserve WHERE reserve_no =?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, rNum);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			list.add(rs.getInt("reserve_no"));
			list.add(rs.getString("theater_no"));
			list.add(rs.getString("seat_no"));
			list.add(rs.getInt("person_num"));
			list.add(rs.getString("pay_sys"));
			list.add(rs.getInt("pay_money"));
		}
		rs.close();
		st.close();
		return list;
	}
	
	
	/**
	 *  역할 : member테이블에서 모든 아이디,이름,전화번호,이메일 가져와서 MemberVO 타입으로 리턴
	 *  		A_MemberView의 모든 이슈마다 JTable 업데이트를 위한 목적
	 */
	public ArrayList select() throws Exception{
		String sql = "SELECT member_id, name, tel, email FROM member";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ArrayList data = new ArrayList();
		
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("member_id"));
			temp.add(rs.getString("name"));
			temp.add(rs.getString("tel"));
			temp.add(rs.getString("email"));
			
			data.add(temp); // arraylist 타입의 2차원 배열
			
		}
		
		rs.close();
		st.close();
		return data;
	}
	
	// ########### A_RegistView ###########
	/**
	 *  역할 : 받아온 값을  DB manager 테이블에 저장
	 */
	public void regist(ManagerVO vo) throws Exception{
		String sql = "INSERT INTO manager(m_id,m_pw,m_name,m_tel,m_birth,hiredate)VALUES (seq_manager_id.NEXTVAL,?,?,?,?,sysdate)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, vo.getMgrPW());
		st.setString(2, vo.getMgrName());
		st.setString(3, vo.getMgrTel());
		st.setDate(4, vo.getMgrBirth());
		st.executeUpdate();
		st.close();
	}
	
	// ########### A_LoginView ###########
	/**
	 *  역할 : 받아온 아이디와 비밀번호를 DB manager 테이블과 비교하여 있으면 0, 없으면 -1 리턴
	 */
	public int login(String id, String pw) throws Exception{
		int result = 0;
		String sql = "SELECT * FROM manager WHERE m_id =? and m_pw =?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,id);
		st.setString(2,pw);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			result = 0;
		}else {
			result =-1;
		}
		rs.close();
		st.close();
		return result;
	}
	/**
	 *  역할 : 얻어온 전화번호와 manager 테이블의 레코드 비교하여 해당하는 사원번호 리턴
	 */
	public String searchID(String tel) throws Exception{
		String id = null;
		
		String sql = "SELECT m_id FROM manager WHERE m_tel=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, tel);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			id = rs.getString("m_id");
		}
		rs.close();
		st.close();
		return id;
	}
	
	
	
	
}
