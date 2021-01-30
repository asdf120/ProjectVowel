$(function () {

        // fontSize 조절
        $('.fontSize>button:first-child').click( () =>{
            $('#txt').css({fontSize : '+=1px'})
            // $('#txt').animate({'fontSize' : '+=1px'},100)
        })
        $('.fontSize>button:last-child').click( () =>{
            $('#txt').css({fontSize : '-=1px'})
            // $('#txt').animate({'fontSize' : '-=1px'},100)
        })

        // font 변경
        $('#fontstyle').change(function () {
            $('#txt').css('font-family', $(this).val());
        });




})  // function(){} END