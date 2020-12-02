<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="temp.*" %>
<%@ page import="form.EmpVO" %>
<%@ page import="form.EmpDao" %>
<%
	request.setCharacterEncoding("utf-8");
//	 TODO
//	 1. 이전 화면에서 사용자 입력값 얻어오기
	int empNo = Integer.parseInt(request.getParameter("empno"));
	String eName = request.getParameter("ename");
	int deptNo = Integer.parseInt(request.getParameter("deptno"));
	String job = request.getParameter("job");
	int sal = Integer.parseInt(request.getParameter("sal"));

	// 2. 위의 얻어온 입력값들을 EmpVo의 멤버로 지정
	EmpVO empVO = new EmpVO(empNo,eName,deptNo,job,sal);

	try{
		// 3. EmpDao 객체 얻어오기
		EmpDao empDao = EmpDao.getInstance();
		// 4. insertEmp() 호출
		empDao.insertEmp(empVO);
	}catch (Exception e){
		System.out.println(e.toString());
	}

%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 사원등록 </title>
</head>
<body>
	 성공적으로 입력되었지 DB에서 확인합니다.
	 <%= empNo%>
	<%= empVO.getEname()%>
</body>
</html>