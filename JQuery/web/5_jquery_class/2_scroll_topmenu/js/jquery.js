/**
 * 
 */

$(function () {

    $('#intro').animate({
        padding: '30px',
        // fontSize: '25px'
    }, 2000);


    $('#navigation li>a').hover(function () {
        $(this).animate({ paddingLeft: '+=15px' }, 300)
    }, function () {
        $(this).animate({ paddingLeft: '-=15px' }, 300)
    })

    // #navigation 스크롤 내려도 화면따라옴
    $(window).scroll(function () {
        $('#navigation').css('top', $(document).scrollTop())
    })

}) // function() END