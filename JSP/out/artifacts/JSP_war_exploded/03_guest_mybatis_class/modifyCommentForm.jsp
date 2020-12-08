<%@ page import="mybatis.guest.model.CommentVO" %>
<%@ page import="mybatis.guest.service.CommentService" %>
<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%
	long commentNo = Integer.parseInt( request.getParameter("commentNo"));

	CommentVO commentVO = CommentService.getInstance().selectCommentByPrimaryKey(commentNo);


%>

<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
<title>입력</title>
</head>
<body>

메세지 수정하기
<form name="frm" action="modifyCommentSave.jsp" method="post">
<table>
	<tr><td>글번호</td><td><input type="text" name="commentNo" value="<%=commentVO.getCommentNo()%>" size="3"/></td></tr>
	<tr><td>사용자</td><td><input type="text" name="userId" value="<%=commentVO.getUserId()%>" size="15"/></td></tr>
	<tr><td>메세지</td><td><textarea name="commentContent" rows="10" columns="40"><%=commentVO.getCommentContent()%></textarea></td></tr>
	<tr><td><input type="submit" value="입력"/></td></tr>
</table>
</form>
</body>
</html>