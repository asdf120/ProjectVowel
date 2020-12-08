<%@ page language="java" contentType="text/html; charset=utf-8" %>
 <%@ page import="java.util.*" %>
 <%@ page import="mybatis.guest.model.CommentVO" %>
 <%@ page import="mybatis.guest.service.CommentService" %>  
  
  <!-- 서비스의 메소드 호출  -->
  <%
     //Map condition = new HashMap();
     List<CommentVO> mList = CommentService.getInstance().selectComment();
 %>
  
<!DOCTYPE HTML>
<html> 
<head>
	<meta charset="UTF-8">
<title>목록보기</title>
</head>
<body>

<a href="insertCommentForm.jsp">방명록 남기기 </a><br/><br/>

<table border="1">
	<tr><td>글번호</td><td>작성자</td><td>등록일</td></tr>
	<% for( CommentVO commentVO : mList ) { %>
		<tr>
			<td><%= commentVO.getCommentNo() %></td>
			<td><a href="viewComment.jsp?cId=<%=commentVO.getCommentNo()%>"><%= commentVO.getUserId()%> 님이 쓴 글</a></td>
			<td><%= commentVO.getRegDate()%></td>
		</tr>
	<% } %>
</table>
</body>
</html>