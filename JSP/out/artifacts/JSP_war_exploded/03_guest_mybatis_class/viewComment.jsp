<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page import="mybatis.guest.model.CommentVO" %>
<%@ page import="mybatis.guest.service.CommentService" %>

<!-- 키에 해당하는 글번호를 넘겨받아 서비스의 메소드 호출 -->
<%
    long commentNo = Integer.parseInt(request.getParameter("cId"));

    CommentVO commentVO = CommentService.getInstance().selectCommentByPrimaryKey(commentNo);
%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title> 메세지 보기 </title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $('#btnDelete').click(() => {
                $('form[name="frm"]').submit()
            })
        })	// function(){} END
    </script>
</head>
<body>
<table border="1">
    <form name="frm" action="deleteComment.jsp">
        <tr>
            <td>작성자</td>
            <td><%=  commentVO.getUserId()%>
            </td>
        </tr>
        <tr>
            <td>메세지</td>
            <td><%=  commentVO.getCommentContent()%>
            </td>
        </tr>
        <tr>
            <td>등록일</td>
            <td><%=  commentVO.getRegDate()%>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" id="btnDelete" value="삭제"/> &nbsp;
    </form>
            <a href="modifyCommentForm.jsp?commentNo=<%=commentNo%>">수정</a>
    </td></tr>
</table>
</body>
</html>