<%@ page language="java" contentType="text/html; charset=utf-8"%>
 <%@ page import="mybatis.guest.model.CommentVO" %>
 <%@ page import="mybatis.guest.service.CommentService" %>   
  
 <!--  이전 폼에서 넘겨오는 데이타의 한글 처리  -->
 <% 
 	request.setCharacterEncoding("utf-8");
 %>
  
 <!--  이전 폼의 각각의 데이터를 빈즈의 멤버로 지정  -->
 <jsp:useBean id="commentVO" class="mybatis.guest.model.CommentVO">
 	<jsp:setProperty name="commentVO" property="*"/>
 </jsp:useBean>   
 
 <!-- 서비스의 메소드 호출  -->
 <%
     System.out.println("modifyCommentSave.jsp 18Line : " +commentVO.getUserId());
     int result = CommentService.getInstance().modifyComment(commentVO);
     System.out.println("modifyCommentSave.jsp 18Line : " +result);
 %>
    
    
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
<title>입력</title>
</head>
<body>
<%
    if(result == 1){
%>
수정 완료 <br/>
<a href="listComment.jsp">목록보기</a>
<%
    }else{
%>
    수정 실패
<%
    }
%>
</body>
</html>