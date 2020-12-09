<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 답변글의 부모 게시글의 번호를 넘겨받기
	String articleId = request.getParameter("articleId");
	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 답변 글쓰기 </title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript">
		$('input[value="작성"]').click(()=>{

		})
	</script>
</head>
 <body>
	<h4> 답변 글 쓰기 </h4><br/>
	
	<form name='frm' action = "/boardController?boardParam=boardReplyOK" method='post'>
		<input type="hidden" name="articleId" value="<%=articleId%>">
	작성자 : <input type='text' name="writerName"><br/><br/>
	제  목 : <input type='text' name="title"><br/><br/>
	내  용 : <textarea name="content" rows='10' cols='40'></textarea><br/><br/>
	패스워드(수정/삭제시 필요) :
			 <input type='password' name="password"><br/><br/>
	<input type='submit' value='작성'>
	<input type='reset' value='취소'>
	</form>

</body>
</html>