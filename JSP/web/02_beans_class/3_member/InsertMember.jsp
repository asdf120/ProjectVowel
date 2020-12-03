<%@ page import="member.beans.MemberDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<!-- 하나씩 천천히 도전합시다 -->

<%request.setCharacterEncoding("utf-8"); // post방식 한글깨짐 처리%>

<!-- javaBean 생성 -->
<jsp:useBean id="member" class="member.beans.Member">
	<jsp:setProperty name="member" property="*"></jsp:setProperty>
</jsp:useBean>

<!-- 3. db에 입력-->
<%
	MemberDao memberDao = MemberDao.getInstance();
	memberDao.insertMember(member);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 회원가입 확인  </title>
</head>
<body>
	아이디 : <%= member.getId()%><br>
	패스워드 : <%= member.getPassword()%><br>
	이름 : <%= member.getName()%><br>
	전화 : <%=member.getTel()%><br>
	주소 : <%=member.getAddr()%><br>
</body>
</html>