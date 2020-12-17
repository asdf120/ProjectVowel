<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>multiInsert.jsp</title>
</head>
<body>

결과
<hr/>
<table border="1">
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>나이</th>
    </tr>
<c:forEach var="member" items="${memberVOList.memberList}">
    <tr>
        <td>${member.id}</td>
        <td>${member.name}</td>
        <td>${member.age}</td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
