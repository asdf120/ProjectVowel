
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>request.jsp</title>
    <link rel="stylesheet" type="text/css" href="/css/requestCss.css"/>
</head>
<body>

request.do 요청에 따른 결과 뷰 페이지 <hr/>
<p>아이디 : ${memberVO.id} <p></p><br/>
이름 : ${memberVO.name} <br/>
나이 : ${memberVO.age} <br/>

<%--상대경로--%>
<img src="../../../imgs/cart.png"> 상대경로 <br/>

<%-- 절대 경로--%>
<img src="/imgs/cart.png">절대경로 <br/>
</body>
</html>
