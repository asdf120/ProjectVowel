/**
 * 
 */

$(function () {
    $('.rollover > img').hover(function () {
        $(this).attr('src', $(this).attr('src').replace('off', 'on'))
    }, function () {
        $(this).attr('src', $(this).attr('src').replace('on', 'off'))
    })

    // $('img[alt=Home]').hover(function () {
    //     $(this).attr({ "src": "imgs/menu01_on.png" });
    // }, function () {
    //     $(this).attr({ "src": "imgs/menu01_off.png" });
    // });


}) // function() END