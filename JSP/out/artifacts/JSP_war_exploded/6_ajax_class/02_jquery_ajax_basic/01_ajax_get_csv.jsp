<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script  type="text/javascript"  src="libs/jquery-1.9.1.min.js"> </script>
	<script type="text/javascript">
		$(function(){
			let param = {cate:'book', name:'kim'}

			//TODO 페이지 요청 이해하고 넘어갈것
			// $.get("01_server.jsp", param, parseData)
			$.ajax({
				type : 'get',
				data : param,
				url : '01_server.jsp',
				success : parseData,
				error:function(err){
					alert('error!!! ' + err)
				}
			})

			alert('전송시작')

			// 응답 데이터 처리
			// CSV포맷  데이터 처리.
			function parseData(strText){

				alert( 'strText : ' + strText );

				let aryData = strText.split("|");

				for(let i=0;i<aryData.length;i++){
					let param  = aryData[i].split("=");
					if( param[0].trim() == 'cate'){  // 공백제거를 하지 않으면 처음에 공백에 들어와서 cate를 찾지 못함
						// document.getElementById("cate").value = param[1];
						$('#cate').val(param[1]);
					}

					if( param[0].trim() == 'name'){
						// document.getElementById("name").value = param[1];
						$('#name').val(param[1]);
					}

				}

			}
		})	// function(){} END
	</script>
</head>


<body>
서버로부터 넘겨받은 데이터<br/>
첫번째 데이터 : <input type="text" name="" id="cate"/><br/>
두번째 데이터 : <input type="text" name="" id="name"/><br/>
</body>
</html>


