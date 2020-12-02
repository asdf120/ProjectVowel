<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 아이디 중복 검사 </title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
        $('#id_check').click(() =>{
        // $('.userinput').keyup( () =>{   // 누르는 순간순간 감지
            $.ajax({
                type:'get',
                url:'./IdCheck.jsp',
                data : {userid : $('.userinput').val()},
                dataType:'text',
                success : (data) =>{
                    // alert(data);
                    console.log(data)
                    if(data.trim(" ") == "YES"){
                        // alert('이미 사용중')
                        $('#idmessage').text('이미 사용중')
                        $('#idmessage').show()
                    }else{
                        // alert('사용 가능')
                        $('#idmessage').text('사용 가능')
                        $('#idmessage').show()
                    }
                }
            })
        })
    }) // function(){} END

</script>

</head>
<body>

<input name="id" type="text" class="userinput" size="15" />
<button type="button" id="id_check">중복체크</button><br/><br/>
<div id="idmessage" style="display:none;"></div>

</body>
</html>