/**
 * 
 */
$(function () {
    $('a[rel="prettyPopin"]:eq(0)').prettyPopin({
        width: 500
    });
    $('a[rel="prettyPopin"]:eq(1)').prettyPopin({
        width: 500,
        callback: function () {
            alert('팝업창이 닫힘')
        }
    });
})