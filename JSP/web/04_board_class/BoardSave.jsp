<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="board.model.*,board.service.*" %>

<%
    // 0. 넘겨받는 한글 깨지지 않도록 지정
    request.setCharacterEncoding("utf-8"); // post방식 한글깨짐 처리

%>
<!-- 1. 전 화면 입력값을 넘겨받아 BoardVO 클래스의 각 멤버필드에 지정 -->
<jsp:useBean id="boardVO" class="board.model.BoardVO">
    <jsp:setProperty name="boardVO" property="*"/>
</jsp:useBean>

<%
    // 2. Service클래스에 write() 함수호출
    int articleId = WriteArticleService.getInstance().write(boardVO);
    response.sendRedirect("BoardView.jsp?articleId=" + articleId);
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>게시판글저장</title>
</head>
<body>
<%--1. BoardVO의 멤버변수(작성자, 제목) 출력--%>
<h3><%=boardVO.getWriterName()%></h3>
<h3><%=boardVO.getTitle()%></h3>

입력되었는지 확인해보시구염...<br/>
만일 안되어도..환장하지 맙시다 !!! ^^<br/><br/>
</body>
</html>