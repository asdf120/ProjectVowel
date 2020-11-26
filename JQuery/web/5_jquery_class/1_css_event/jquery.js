/**
 * 
 */
$(function () {

    // 테이블의 짝수행에 색상 부여
    // $('tr:even').css({ color: 'yellow', background: '#cccccc' })
    $('#celebs tbody > tr:odd').css({ color: 'yellow', background: '#cccccc' })

    // 짝수행에 table_striping 클래스 적용
    // $('#celebs tbody > tr:odd').addClass('table_striping')

    // 테이블에 마우스가 올라가면 td_mouseover 클래스 적용하고
    // 마우스가 내려가면 td_mouseover 클래스 제거
    $('#celebs tbody > tr').hover(function () {
        $(this).addClass('td_mouseover')
    }, function () {
        $(this).removeClass('td_mouseover')
    })

    // 감추기
    $('#hideButton').click(() => {
        $('#intro').fadeOut();
    })

    // 보이기
    $('#showButton').click(() => {
        $('#intro').fadeIn();
    })

    // 감추기/보이기
    $('#toggleButton').click(() => {
        // $('#intro').fadeToggle();
    })

    // let hidden;
    // $('#toggleButton').click(() => {
    //     hidden = !hidden
    //     hidden ? $('#intro').fadeOut() : $('#intro').fadeIn()
    //     // $('#intro').fadeToggle();
    // })

}) // $(function () END