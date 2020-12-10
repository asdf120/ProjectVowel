<%@ page import="member.beans.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    Member member = new Member();
    member.setName("기묭관");
    member.setId("920210-1111111");
%>

이름 : ${member.name} / 번호 : ${member.id}<br/>
이름 : <%=member.getName()%> / 번호 : <%=member.getId()%>
<hr/>

<c:set var="member" value="<%=member%>"/>
이름 : ${member.name} / 번호 : ${member.id}<br/>



</body>
</html>
