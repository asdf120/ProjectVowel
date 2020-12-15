
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request.jsp</title>
</head>
<body>
<h2>폼 요청</h2>
<form action="board/request.do" method="post">
    <%-- name 부여시 중요사항 VO와 맞출것 --%>
    아이디 : <input type="text" name="id"><br/>
    이름 : <input type="text" name="name"><br/>
    나이 : <input type="number" name="age"><br/>
    <input type="submit" value="전송">
</form>

</body>
</html>
