<%--
  Created by IntelliJ IDEA.
  User: Yonggwan
  Date: 2020-12-01
  Time: 오전 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
    // TODO POST방식 한글처리
    request.setCharacterEncoding("utf-8");

    // 1. 이전 화면에서 사용자 입력 값 얻어오기
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");
    String job = request.getParameter("occupation");
    String[] hobby = request.getParameterValues("hobby");   //체크박스 여러개 가져올때
//    String hobbies = "";
//    if (hobby != null) {
//        for(String temp : hobby){
//            hobbies += temp + " / ";
//        }
//    }
//
//    for(int i = 0; hobby!=null && i<hobby.length; i++){
//        hobbies += hobby[i] + "/";
//    }
%>
<html>
<head>
    <title>02_SimpleForm에 대한 result</title>
</head>
<body>
<%-- 2. 얻어온 입력값 출력 --%>
이름 : <%= name%> <br/>
성별 : <%= gender%><br/>
직업 : <%= job%><br/>
취미 : <% for(String hobbies : hobby){ %>
        <%=hobbies%>
        <%} %>
<%--취미 : <%= hobbies%>--%>
</body>
</html>
