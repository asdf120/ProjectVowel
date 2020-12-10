<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>basic.jsp</title>
</head>
<body>

<%-- 변수 선언 --%>
<c:set var="gender" value="male"/> <!-- String gender="male" -->

<%-- 제어 흐름--%>
<c:if test="${gender=='male'}">당신은 남자입니다</c:if>
<c:if test="${gender=='female'}">당신은 여자입니다</c:if>

<%-- age변수에 24를 지정, 만일 age가 20이상이면 '성인'출력--%>
<c:set var="age" value="24"/>
<c:if test="${age >= 20}">성인</c:if>
<hr/>
<c:choose>
    <c:when test="${age<10}"></c:when>
    <c:when test="${age>=10 && age<20}"></c:when>
    <c:otherwise>성인</c:otherwise>
</c:choose>
<hr/>

<c:set var="sum" value="0"></c:set>
<c:forEach var="i" begin="1" end="100">
    <c:set var="sum" value="${sum+i}"/>
</c:forEach>
1~100 까지의 합 : ${sum} <br/>

<%-- 1~ 100 까지에서 홀수의 합과 짝수의 합 출력--%>
<c:set var="oddSum" value="0"></c:set>
<c:set var="evenSum" value="0"/>
<c:forEach var="i" begin="1" end="100">
    <c:choose>
        <c:when test="${i%2==1}">
            <c:set var="oddSum" value="${oddSum+i}"/>
        </c:when>
        <c:otherwise>
            <c:set var="evenSum" value="${evenSum+i}"/>
        </c:otherwise>
    </c:choose>

</c:forEach>
홀수의 합 : ${oddSum} <br/>
짝수의 합 : ${evenSum} <br/>



</body>
</html>
