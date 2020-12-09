<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>start.jsp</title>
</head>
<body>

    <a href="simpleView.jsp">기존 방식</a>

    <%--TODO 절대경로 알아보기--%>
    <a href="/05_mvc_class/1_mvcSimple/simpleView.jsp">기존 방식(절대)</a>

    <a href="/simple">MVC 방식</a>

    <a href="/simple?type=first">mvc First</a>
    <a href="/simple?type=second">mvc second</a>


    <%--확장자 앞에 명칭은 안따짐--%>
    <a href="/kosmo.kim">MVC 방식2</a>

</body>
</html>
