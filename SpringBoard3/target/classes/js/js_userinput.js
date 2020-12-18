$(function () {
    // 사용자의 자료 입력여부를 검사하는 함수
    $('#confirm').click(function () {
        if ($.trim($("#userId").val()) == '') {
            alert("아이디를 입력해 주세요.");
            $("#userId").focus();
            return;
        }

        if ($.trim($('#userPass').val()) == '') {
            alert("비번입력해주세요.");
            $('#userPass').focus();
            return;
        }

        if ($.trim($('#userPass').val()) != $.trim($('#userPass2').val())) {
            alert("비밀번호가 일치하지 않습니다..");
            $('#userPass2').focus();
            return;
        }


        if ($.trim($('#userName').val()) == '') {
            alert("이름입력해주세요.");
            $('#userName').foucs();
            return;
        }

        // 자료를 전송합니다.
        document.userinput.submit();
    });

    //아이디 중복체크 ( 최근에는 키이벤트 안함 )
    // $('#userId').keyup(function () {
    //     alert("뭐지")
    //     $.ajax({
    //         type: 'post',	// 전송방식
    //         async: true,	// 비동기통신 (ajax에서는 기본값이 true)
    //         url: 'idCheck.do', // 요청(request)
    //         contentType: 'application/x-www-form-urlencoded;charset=utf-8',
    //         data: {'userId': $('#userId').val()},
    //         success: function (result) {
    //             $('#idChecResult').text(result);
    //         },
    //         error: function (err) {
    //             console.log(err);
    //         }
    //     })
    // })

    //태양형이 보내준거
    $('#userId').keyup(function(){
        $.ajax({
            type : 'post', // 전송 방식 (큰 의미 없음)
            async : true, // 비동기통신 여부? 기본값 true
            url : 'idCheck.do', // 비동기통신 요청 request
            contentType : 'application/x-www-form-urlencoded;charset=utf-8', // 한글 처리
            data : {
                'userId' : $('#userId').val() // 보내는 데이터
            },
            success : function (result) {
                $('#idCheckResult').text(result); // 성공했을 때
            },
            error : function (err) {
                console.log(err);
            }
        });
    })


}) //function(){} END


	
	
	
	
	
	
	