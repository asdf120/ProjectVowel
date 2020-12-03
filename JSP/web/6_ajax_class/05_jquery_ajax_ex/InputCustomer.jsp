<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 고객관리 프로그램 </title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" >
	$(function(){
		$('#btnInsert').click(()=>{
			// 정상적인 통신
			// $('form[name="inForm"]').attr('action','./DataInput.jsp');	// 동적으로 폼에 액션 속성 부여
			// $('form[name="inForm"]').submit()
			let param = {
				name : $('#name').val(),
				age : $('#age').val(),
				tel : $('#tel').val(),
				addr : $('#addr').val()
			}
			$.ajax({
				type : 'get',
				data : param,	// param을 해당 url로 전송
				url:'DataInput.jsp',
				success : (result) => {
					//TODO jsp로 돌아올때 반드시 트림해줄것
					if(result.trim(" ") == 1){
						alert('입력 성공')
					}else{
						alert('입력 실패')
					}
				},error : (err) => {
					cosnole.log(err)
				}
			})

		})

		// '가져오기' 버튼 눌렀을ㄸㅐ
		// DB의 값을 가져와 테이블에 출력
		$('#btnSelect').click(()=>{
			// $('#listTable tr:nth-child(n+2)').remove();
			// $('.user').remove();
			$('.user').detach();
			$.ajax({
				url : 'DataSelect.jsp',
				dataType : 'xml',
				success : (result) => {
					let person = $('person',result);

					person.each(function(){
						let name = $('name',$(this)).text();
						let age = $('age',$(this)).text();
						let tel = $('tel', $(this)).text();
						let addr = $('addr',$(this)).text();

						let tr = $('<tr class="user"></tr>')
						$('#listTable').append(tr)
						tr.append('<td>' + name + '</td>' +
								'<td>' + age + '</td>' +
								'<td>' + tel + '</td>' +
								'<td>' + addr + '</td> <br/>')

					})
				}
			})
		})

	}) // funtion(){} END
</script>

</head>


<!-- <body> -->
<body>

<h2> 고객정보 입력 </h2>

<form name="inForm" method="post">
<table border = 1>
	<tr>
		<td width="80" align="center">Name</td>
		<td width="50" align="center">Age</td>
		<td width="100" align="center">Tel</td>	
		<td width="250" align="center">Addr</td>
	</tr>
	<tr>
		<td align="center"><input type="text" size="8" name="name" id="name"></td>
		<td align="center"><input type="text" size="4" name="age" id="age"></td>
		<td align="center"><input type="text" size="12" name="tel" id="tel"></td>
		<td align="center"><input type="text" size="30" name="addr" id="addr"></td>
	</tr>
	<tr>
		<td colspan="4" align="center"> 
			<input type="button" id ='btnInsert' value="입력">
		</td>
	</tr>
</table>

<br>
<hr>

<h2> 고객정보 목록보기  </h2>
<table border='0' width="510"> 
	<tr>
		<td align="right"><input type="button" id='btnSelect' value="가져오기"></td>
	</tr>
</table>
<table border = 1 id="listTable">
	<tr>
		<td width="80" align="center">Name</td>
		<td width="50" align="center">Age</td>
		<td width="250" align="center">Tel</td>
		<td width="100" align="center">Addr</td>
	</tr>
</table>
<div id="myDiv"> </div>

</form>
</body>
</html>