<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String msgId = request.getParameter("msgId");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 방명록 삭제 </title>
</head>
<body>
	메세지를 삭제하려면 암호를 입력하세요. <br/><br/>
	<form action="deleteConfirm.jsp" method="post">
		<%-- type ="hidden" =>사용자에게 보이지 않게 보낼수있음--%>
		<%--<iuput type="hidden" name="msgId" value='<%=msgId%>'/>--%>
			<input type="hidden" name="msgId" value="<%= msgId %>"/>
		암호 : <input type="password" name="password" />
		<input type="submit" value="메세지 삭제"/>
	</form>
</body>
</html>