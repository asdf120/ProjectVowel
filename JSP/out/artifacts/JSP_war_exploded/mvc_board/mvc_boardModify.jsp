
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int result = (Integer)request.getAttribute("result");
    int articleId = (Integer)request.getAttribute("articleId");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>게시판글수정</title>
</head>
<body>

<%  // 게시글 수정이 성공적으로 되었다면 그 해당 게시글을 보여주는 페이지로 이동하고
    // 그렇지 않다면, "암호가 잘못 입력되었습니다"를 출력
    if(result == 1) {%>
        글 수정 완료
    <a href="/boardController?boardParam=mainList"> 게시판 </a><br/><br/>
    <%} else{ %>
<h3>암호가 잘못 입력되었습니다.</h3>
<% } %>
</body>
</html>