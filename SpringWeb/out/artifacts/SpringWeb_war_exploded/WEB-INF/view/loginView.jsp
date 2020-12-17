<%--
  Created by IntelliJ IDEA.
  User: Yonggwan
  Date: 2020-12-16
  Time: 오후 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginView.jsp</title>
</head>
<body>

${param.id}님 로그인 성공 <hr/>

${userVO.id}님 로그인 성공 <hr/>

세션에서 로그인한 값 얻어오기
${sessionScope.userId}님 로그인 성공


</body>
</html>
