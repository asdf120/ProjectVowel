<%--
  Created by IntelliJ IDEA.
  User: Yonggwan
  Date: 2020-12-16
  Time: 오전 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>memberListProp.jsp</title>
</head>
<body>
<h2> 리스트 타입의 Property</h2>
<form action="multiInsert.do" method="post">
    <table>
        <tr>
            <th width="100">선택</th>
            <th width="200">아이디</th>
            <th width="300">이름</th>
            <th width="100">나이</th>
        </tr>
        <tr>
            <td><input type="checkbox" name="memberList[0].state"></td>
            <td><input type="text" name="memberList[0].id"></td>
            <td><input type="text" name="memberList[0].name"></td>
            <td><input type="text" name="memberList[0].age"></td>
        </tr>
        <tr>
            <td><input type="checkbox" name="memberList[1].state"></td>
            <td><input type="text" name="memberList[1].id"></td>
            <td><input type="text" name="memberList[1].name"></td>
            <td><input type="text" name="memberList[1].age"></td>
        </tr>
        <tr>
            <td><input type="checkbox" name="memberList[2].state"></td>
            <td><input type="text" name="memberList[2].id"></td>
            <td><input type="text" name="memberList[2].name"></td>
            <td><input type="text" name="memberList[2].age"></td>
        </tr>
        <tr>
            <td colspan="4" align="center"><input type="submit" value="전송"> </td>
        </tr>
    </table>
</form>
</body>
</html>
