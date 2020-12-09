<%@ page import="mvc_board.model.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>게시판 글쓰기</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $('input[type="button"]').click(()=>{
                $('form[name="frm"]').submit()
            })

        }) //function(){} END
    </script>
</head>
<body>
<h4> 게시판 글쓰기 </h4><br/>
<body>
<h4> 게시판 글 쓰기 </h4><br/>
나중에 이쁘게 만드시오 <br/><br/>
<form action="/boardController?boardParam=boardInsertOK" name='frm' method='post'>
    작성자 : <input type='text' name="writerName"><br/><br/>
    제  목 : <input type='text' name="title"><br/><br/>
    내  용 : <textarea name="content" rows='10' cols='40'></textarea><br/><br/>
    패스워드(수정/삭제시 필요) :
    <input type='password' name="password"><br/><br/>
    <input type='button' id = 'writeBtn' value='작성'>
    <input type='reset' id = 'cancel' value='취소'>
</form>

</body>

</body>
</html>