<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="guest.service.ListMessageService,guest.vo.MessageVO" %>
<%@ page import="java.util.List" %>
<%@ page import="guest.model.MessageException" %>

<%
    String currentPage = request.getParameter("currentPage");
    int pageNo = 1;
    if(currentPage != null){
        pageNo = Integer.parseInt(currentPage);
    }
    List<MessageVO> mList = null;
    int totalPageCount= 0;

    try{
        mList = ListMessageService.getInstance().getMessageList(pageNo);
        ListMessageService listMessageService = ListMessageService.getInstance();

        totalPageCount = listMessageService.getTotalPage();
        System.out.println("listMessage.jsp 21line : " + totalPageCount);
    }catch (MessageException e){
        System.out.println(e.toString());
    }

%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> 방명록 목록 </title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>

<% if (mList.isEmpty()) { %>
남겨진 메세지가 하나도~~없습니다. <br>
<% } else { %>
<table border="1">

    <% for (MessageVO messageVO : mList) { %>
    <tr>
        <td><%=messageVO.getId()%>
        </td>
        <td><%=messageVO.getGuestName()%>
        </td>
        <%--?==> 쿼리스트링 --%>
        <td><a href='deleteMessage.jsp?msgId=<%=messageVO.getId()%>'>삭제</a></td>
    </tr>
    <tr>
        <td colspan='3'>
            <textarea cols=35 rows=3
                      style="font-family: '돋움', '돋움체'; font-size: 10pt; font-style: normal; line-height: normal; color: #003399;background-color:#D4EBFF;border:1; solid: #00009C;"><%=messageVO.getMessage()%></textarea>
        </td>
    </tr>
    <% } // end of for %>
</table>

<% } // end if-else %>
글쓰기

<% for (int i = 1; i <= totalPageCount; i++) { %>
<a href='listMessage.jsp?currentPage=<%=i%>'>[ <%= i%>  ]</a>
<% } //end of for %>
</body>
</html>