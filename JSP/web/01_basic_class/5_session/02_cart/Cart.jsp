<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="cart.Goods" %>
<%
	request.setCharacterEncoding("utf-8");

	// 1. Form의 값(hidden값) 넘겨받기 ( id, name, price )
	String id= request.getParameter("id");
	String name =request.getParameter("name");
	int price= Integer.parseInt(request.getParameter("price"));

	ArrayList<Goods> glist = null;

	request.setCharacterEncoding("utf-8");

	// 2. 세션의 cart 속성을 얻어온다.
	Object objCart = session.getAttribute("cart");

	// 3. 만일 null이면 ArrayList 객체 새로 생성하고 그렇지 않으면 ArrayList 변수(glist)에 지정
	if(objCart == null){
		glist = new ArrayList<>();
	}else{
       glist = (ArrayList)objCart;
	}
	// 4. 1번의 값들을 Goods 객체로 생성후 ArrayList 에 추가
	Goods good = new Goods(name,price);
	glist.add(good);
	// 5. 세션에 cart 라는 이름에 ArrayList를 저장
	session.setAttribute("cart",glist);
%>

<html>
<body bgcolor=white>
<%= name %> 을 구입하셨습니다.

<br><br><br>

<table>
<tr bgcolor="#e7a068"><th>상품명</th>
<th>가격</th></tr>

<%
		int n = glist.size(); // 리스트 사이즈
		int sum = 0;
		for(int i=0; i < n; i++) {
			Goods goods = glist.get(i);
			int gp = goods.getPrice();
			sum += gp;
%>
			<tr><td align="center"> <%= goods.getName() %> </td>
				<td align="right"> <%= gp %> </td></tr>
<%
		}
%>

<tr bgcolor="#e7a068"><td colspan="2" align="right"> 총액 : <%= sum  %></td></tr>
</table>

<br/><br/>
[<a href="wshop.jsp">쇼핑하러 가기</a>]
[<a href="Buy.jsp">구입하기</a>]

</body></html>

