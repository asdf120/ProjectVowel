<%@ page import="mvc_board.model.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    BoardVO boardVO = (BoardVO)request.getAttribute("boardVo");
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>게시글 수정하기</title>

</head>
<body>
<h4> 게시판 글 수정하기 </h4><br/>
<form name='frm' action="/boardController?boardParam=boardModifyOK" method='post'>
    <input type="hidden" name="articleId" value="<%= boardVO.getArticleId() %>"/>
    제  목 : <input type='text' name="title" value="<%=boardVO.getTitle()%>"><br/><br/>
    패스워드(수정/삭제시 필요) :
    <input type='password' name="password"><br/><br/>
    내  용 : <textarea name='content' rows='10' cols='40'><%=boardVO.getContent()%></textarea><br/><br/>

    <input type='submit' value='수정하기'>
    <input type='button' value='목록보기' onclick="window.location='BoardList.jsp'">
</form>

</body>
</html>