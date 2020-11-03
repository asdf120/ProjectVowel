package jdbc.transection;

import java.sql.*;
public class AccLogic 
{
	// 연결 객체 생성시 필요한 변수 선언
	String url;
	String user;
	String pass;

	//===============================================
	// 드라이버를 드라이버매니저에 등록
	public AccLogic() throws Exception{
		/////////////////////////////////////////////////////////
		// 1. 드라이버를 드라이버 매니저에 등록
		Class.forName("oracle.jdbc.driver.OracleDriver");
		url = "jdbc:oracle:thin:@localhost:1521:orcl";
		user = "kosmo_04";
		pass = "kosmo";
	}


	//====================================================
	// 보내는 계좌번호와 받는 계좌번호와 계좌금액을 넘겨받아 
	//	보내는계좌에서 계좌금액을 빼고 받는계좌에서 계좌금액을 더한다
	public int moveAccount(String sendAcc, String receiveAcc, int amount)
	{
		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try{
			//	 1. Connection 객체 생성
			con = DriverManager.getConnection(url,user,pass);

			//@@ 2. Auto-commit을 해제
			con.setAutoCommit(false);

			//	 3. 출금계좌에서 이체금액을 뺀다
			String sql1 = "UPDATE account SET amount = amount-? where account_num = ? ";
			ps1 = con.prepareStatement(sql1);
			ps1.setInt(1,amount);
			ps1.setString(2,sendAcc);
			int result1 = ps1.executeUpdate();
			if (result1 == 0) {
				System.out.println("없는 계좌 : " + sendAcc);
				con.rollback();
				return -1;
			}
			//	 4. 입금계좌에 이체금액을 더한다
			String sql2 = "UPDATE account SET amount = amount+? where account_num = ? ";
			ps2 = con.prepareStatement(sql2);
			ps2.setInt(1,amount);
			ps2.setString(2,receiveAcc);
			int result2 = ps2.executeUpdate();
			if (result2 == 0) {
				System.out.println("없는 계좌 : " + receiveAcc);
				con.rollback();
				return -1;
			}
			//@@ 5. commit을 전송한다
			con.commit();
		}catch (Exception e){
			try{
				con.rollback();
			}catch (Exception ex){
				ex.printStackTrace();
			}
			return -1;
		}finally {
			try{
				//	 6. 객체 닫기
				ps1.close();
				ps2.close();
				con.close();
			}catch (Exception e){
				System.out.println("AccLogic : " +e.toString());
			}
		}
		return 0;
	}

	//=======================================================
	//	보내는계좌번호와 받는계좌번호를 넘겨받아
	//		보내는계좌고객명과 보내는계좌의남은 금액을 얻어오고
	//		받는계좌고객명을 얻어와서
	//		얻은 정보를 ConfirmData객체에 넣고 리턴
	public ConfirmData confirmAccount(String sendAcc, String recvAcc) 
		throws Exception{

		
		String sendCust="", recvCust="";
		int gainMoney=0;
		ConfirmData  resultData=null;
		
		//	1. Connection 객체 생성
		//	2. 테이블에서, 넘겨받은 sendAcc와 같은 account_num필드에서 customer, amount를 얻어온다
		//	3. 테이블에서, 넘겨받은 recvAcc와 같은 account_num필드에서 customer를 얻어온다
		//  4. 2와 3에서 얻은 값을 ConfirmData 객체에 저장
		//	5. 4번의 객체를 리턴



		return resultData;
	}

}


//#################################################################
//	테이블명 : account
//	account_num		계좌번호		varchar2(20)
//	customer		고객명			varchar2(20)
//	amount			계좌금액		int
