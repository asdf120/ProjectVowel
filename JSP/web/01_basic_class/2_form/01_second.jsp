<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%
	String user = request.getParameter("User");
	String pass = request.getParameter("Pass");

	// 1. 드라이버 로딩
	Class.forName("oracle.jdbc.driver.OracleDriver");
	// 2. 연결객체 얻어오기
	String url = "jdbc:oracle:thin:@localhost:1536:orcl";
	String dbUser = "scott";
	String dbPass = "tiger";
	Connection con = DriverManager.getConnection(url, dbUser, dbPass);
	// 3. sql 문장 만들기
	String sql = "SELECT * FROM emp WHERE ename = UPPER(?) AND empno = ?";
	// 4. 전송 객체 얻어오기
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1,user);
	ps.setInt(2,Integer.parseInt(pass));
	// 5. 전송
	ResultSet rs = ps.executeQuery();
%>
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 폼의 입력값 처리 </title>
</head>
<body>

	<%
		if (rs.next()) {
	%> 해당사원이 존재하여 로그인 성공
	<%
		} else{ %>
		사원명이나 사번이 틀림
	<%
		}
	%>

	<br>
	유저 이름:<%=user%>
	사번 : <%=pass%>
	입력한 아이디 : <%= user %> <br/>
	입력한 패스워드 :  <%= pass %>
</body>
</html>