<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>		


<%	
	// 1. Cookie 객체 생성
	Cookie cookie = new Cookie("yourId","kyg");

	// 2. 속성 부여
	//유효기간 설정
	cookie.setMaxAge(1*30); // 1분
	// 3. 클라이언트에 쿠키 전송
	response.addCookie(cookie);
%>

<html>
<head><title>쿠키</title></head>
<body>

<b>Simple Cookie Example</b><hr>

<br><a href="01_GetCookie.jsp"> 쿠키검색 </a>

</body></html>