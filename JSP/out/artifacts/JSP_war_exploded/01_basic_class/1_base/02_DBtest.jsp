<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>

<%-- 에러 처리 페이지--%>
<%@ page errorPage="02_NormalErrorPage.jsp" %>

<%
    //TODO 안되면 톰캣 lib에 jdbc넣기
    // 1. 드라이버 로딩
    Class.forName("oracle.jdbc.driver.OracleDriver");
    // 2. 연결객체 얻어오기
    String url = "jdbc:oracle:thin:@localhost:1536:orcl";
    String user = "scott";
    String pass = "tiger";
    Connection con = DriverManager.getConnection(url, user, pass);
    // 3. sql 문장 만들기
    String sql = "SELECT * FROM emp2";
    // 4. 전송 객체 얻어오기
    PreparedStatement ps = con.prepareStatement(sql);
    // 5. 전송
    ResultSet rs = ps.executeQuery();
%>


<!DOCTYPE html>
<html>
<head><title> 디비 테스트 </title>
</head>
<body>

<div align=center>
    <table border=2 cellSpacing=3>

        <tr class="title">
            <td>사번</td>
            <td>사원명</td>
            <td>업무</td>
            <td>관리자사번</td>
            <td>입사일</td>
        </tr>

        <% while (rs.next()) { %>

        <tr>
            <td><%= rs.getInt("EMPNO")%>
            </td>
            <td><%= rs.getString("ENAME")%>
            </td>
            <td><%= rs.getString("JOB")%>
            </td>
            <td><%= rs.getInt("MGR")%>
            </td>
            <td><%= rs.getDate("HIREDATE")%>
            </td>
        </tr>
        <% } // end of while %>

    </table>
</div>
</body>
</html>
