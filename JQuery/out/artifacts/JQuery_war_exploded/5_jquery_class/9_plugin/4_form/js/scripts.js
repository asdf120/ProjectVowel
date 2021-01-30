/**
 *
 */
$(function () {

    $('#signup form').validate({
        rules: {
            name: { required: true, minlength: 3 },  // 이름에 대한 유효성
            email: { email: true },
            passconf: { equalTo: '#password' }
        },
        //성공시 이벤트
        success: function (label) {
            label.addClass('valid')
            label.text('성공') // 출력은 안되지만 없으면 녹색체크가 안됨
        }
    })

    let hidden = true;
    // 체크목록
    $('.check-all').click(function () {
        // if (hidden) {
        //     // $(this).prop('checked', true)
        //     $('.agree').prop('checked', true)
        //     hidden = false;
        // } else if (!hidden) {
        //     // $(this).prop('checked', false)
        //     $('.agree').prop('checked', false)
        //     hidden = true;
        // }

        // $(this).is(':checked') ?
        // $('.agree').prop('checked', true) : $('.agree').prop('checked', false);
        $('.agree').prop('checked', $(this).is(':checked'))
    })

    // TODO 개별 체크 처리
    $('.agree').click(function () {
        $('.check-all').prop('checked', $(this).is(':checked'))
    })

})  // function(){} END