<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <script type="text/javascript" src="libs/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            let param = {cate: 'IT', name: 'hong'}

            $.ajax({
                type: 'post',
                data: param,
                dataType: 'text',
                url: '04_server.jsp',
                success: (result) => {
                    // alert(result)
                    let obj = {}
                    obj = eval("(" + result + ")"); // eval() ==> text 타입을 json 객체로 변환
                    $('#cate').val(obj.first)
                    $('#name').val(obj.second)
                },
                error: () => {	// 생략해도 상관없음
                    alert('서버로부터 응답받지못함')
                }
            })
        })	// function(){} END
    </script>
</head>

<body>
서버로부터 넘겨받은 데이터<br/>
첫번째 데이터 : <input type="text" name="" id="cate"/><br/>
두번째 데이터 : <input type="text" name="" id="name"/><br/>
</body>
</html>


