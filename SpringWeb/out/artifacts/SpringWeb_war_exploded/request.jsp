
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request.jsp</title>
</head>
<body>

<h1>요청 연습</h1>
<a href="board/a.do">요청1</a>
<a href="board/b.do">요청2</a>
<a href="board/c.do?id=kim">요청3</a>
<a href="board/c.do">요청4</a>

<h2>폼 요청</h2>
<form action="board/request.do" method="post">
    <%-- name 부여시 중요사항 VO와 맞출것 --%>
    아이디 : <input type="email" name="id"><br/>
    이름 : <input type="text" name="name"><br/>
    나이 : <input type="number" name="age"><br/>
    <input type="submit" value="전송">
</form>

<form action="board/request.do">
    <%-- name 부여시 중요사항 VO와 맞출것 --%>
    아이디 : <input type="email" name="id"><br/>
    이름 : <input type="text" name="name"><br/>
    나이 : <input type="number" name="age"><br/>
    <input type="submit" value="전송">
</form>

</body>
</html>
