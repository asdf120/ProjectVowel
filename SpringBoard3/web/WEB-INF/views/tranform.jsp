<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>계좌이체</title>
</head>
<body>

	<form method="post" action="transfer.do">
	
		보내는 사람 :<input type="text" name="send_num" value="111-11-1111"><br/>
		보내는 계좌 :<input type="text" name="send_customer" value="홍길동"><br/>
		금액 : <input type="text" name="amount"><br/>
		
		받는 사람 : <input type="text" name="recv_num" value="999999-999"><br/>
		받는 계좌 : <input type="text" name="recv_customer" value="춘향"><br/>
		
		    <input type="submit">
	</form>
	
</body>
</html>