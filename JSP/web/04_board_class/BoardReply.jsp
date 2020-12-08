<%@ page import="board.model.BoardVO" %>
<%@ page import="board.service.ReplyArticleService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="boardVo" class="board.model.BoardVO">
	<jsp:setProperty name="boardVo" property="*"/>
</jsp:useBean>

<%
	// 1. 부모게시물의 게시번호를 넘겨받기
	String articleId = request.getParameter("articleId");
	System.out.println("BoardReply.jsp 15line : " + boardVo.getTitle());
	// 2. Service에 reply() 호출하여 답변글 등록하기
	BoardVO boardVoReply = ReplyArticleService.getInstance().reply(articleId,boardVo);

%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 답변 글 저장하기 </title>
</head>
<body>

답변글을 등록하였습니다. <br/><br/>
30행 : <%=boardVo.getTitle()%>
<a href="BoardList.jsp"> 목록보기 </a> &nbsp;
<a href="BoardView.jsp?id=<%=boardVoReply.getArticleId()%>"> 게시글 읽기 </a>

</body>
</html>