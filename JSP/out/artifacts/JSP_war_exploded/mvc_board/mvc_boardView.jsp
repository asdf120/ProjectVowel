<%@ page import="mvc_board.model.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    BoardVO boardVo = (BoardVO)request.getAttribute("boardVo");
    System.out.println("boardView 8Line : " + boardVo.getTitle());
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> 게시글 보기 </title>
</head>
<body>

<h4> 게시판 글 보기 </h4><br/>
<table border="1" bordercolor="red">
    <tr>
        <td> 제 목 :</td>
        <td><%=boardVo.getTitle()%>
        </td>
    </tr>
    <tr>
        <td> 작성자 :</td>
        <td><%=boardVo.getWriterName()%>
        </td>
    </tr>
    <tr>
        <td> 작성일자 :</td>
        <td><%=boardVo.getPostingDate()%>
        </td>
    </tr>
    <tr>
        <td> 내 용 :</td>
        <td><%=boardVo.getContent()%>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <a href="/boardController?boardParam=mainList">목록보기</a>
            <a href="/boardController?boardParam=boardReply&articleId=<%=boardVo.getArticleId()%>">답변하기</a>
            <a href="/boardController?boardParam=boardModify&articleId=<%=boardVo.getArticleId()%>">수정하기</a>
            <a href="/boardController?boardParam=deleteBoard&articleId=<%=boardVo.getArticleId()%>">삭제하기</a>
        </td>
    </tr>
</table>


</body>
</html>