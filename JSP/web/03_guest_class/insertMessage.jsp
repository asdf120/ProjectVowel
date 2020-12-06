<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 방명록 </title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript">
		let validate = true;
		let nameCheck = RegExp(/^[가-힣]+$/)
		let passCheck = RegExp(/^[a-zA-Z0-9]{4,12}$/)
		$(function(){
			//TODO 유효성검사해주기

			// 이름 유효성
			$('input[name="guestName"]').blur(()=>{
				if($('input[name="guestName"]').val() == "") {
					$('#idCheck').css({
						color: 'red'
					})
					$('#idCheck').html("이름을 입력해주세요")
					validate = false;
				}else if(!nameCheck.test($('input[name="guestName"]').val())){
					$('#idCheck').css({
						color: 'red'
					})
					$('#idCheck').html("한글형식으로 입력해주세요")
					validate = false;
				}else{
					$('#idCheck').html("")
					validate = true;
				}
			})

			// 비밀번호
			$('input[name="password"]').blur(() => {
				if($('input[name="password"]').val() == ""){
					$('#passCheck').css({
						color :'red'
					})
					$('#passCheck').html('비밀번호를 입력해주세요')
					validate = false;
				}else if(!passCheck.test($('input[name="password"]').val())){
					$('#passCheck').css({
						color :'red'
					})
					$('#passCheck').html('비밀번호양식에 맞게 입력해주세요')
					validate = false;
				}else{
					$('#passCheck').html("")
				}
			})


			$('input[type="button"]').click(()=>{
				if(validate){
					$('form[name="frm"]').submit()
				}else{
					alert('양식에 맞게 작성해서 다시 눌러주세요')
				}
			})

		}) // funtion(){} END
	</script>
</head>

<body>

	<form action="saveMessage.jsp" name="frm" method="post">
		이름 : <input type="text" name="guestName" required />
		<p id="idCheck"></p>
		암호 : <input type="password" name="password" required /><br/><br/>
		<p id="passCheck">4자이상 12이하로 입력해주세요</p>
		메세지 : <textarea name="message" rows="3" cols="30" required></textarea><br/><br/>
		<input type="button" value="메세지 남기기">
	</form>
</body>
</html>