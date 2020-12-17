<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세</title>
</head>
<body>
		<h1>글 상세</h1>		
		<hr>
		<form action="updateBoard.do" method="post">
			<input name="b_id" type="hidden" value="${board.b_id}" />
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input name="b_title" type="text"
						value="${board.b_title }" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left">${board.b_name }</td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
					<td align="left">
						<c:if test="${board.b_fname != null}">
						<%--<img src="../../upload/${board.b_fname}">--%>
							<img src="/upload/${board.b_fname}">
						</c:if>
						<textarea name="b_content" cols="40" rows="10">${board.b_content }</textarea></td>
				</tr>
				<tr>
					<td bgcolor="orange">등록일</td>
					<td align="left">${board.b_date }</td>
				</tr>
				<tr>
					<td bgcolor="orange">조회수</td>
					<td align="left">${board.b_count }</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="글 수정" /></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertBoard.do">글등록</a>&nbsp;&nbsp;&nbsp; 
		<a href="deleteBoard.do?b_id=${board.b_id }">글삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.do">글목록</a>
</body>
</html>
