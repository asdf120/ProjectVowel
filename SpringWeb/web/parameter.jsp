<%--
  Created by IntelliJ IDEA.
  User: Yonggwan
  Date: 2020-12-16
  Time: 오후 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>parameter.jsp</title>
</head>
<body>
<a href="param.do?cate=book&kind=it">요청시 파라미터 전송</a>

<h1>로그인</h1>

<form action="login.do" method="get">
    아이디 : <input type="text" name="id"><br/>
    비밀번호 : <input type="password" name="password"><br/>
    <input type="submit" value="로그인">
</form>

</body>
</html>
