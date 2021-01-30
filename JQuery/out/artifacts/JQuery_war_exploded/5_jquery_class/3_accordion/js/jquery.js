/**
 * 
 */

 $(function(){

    $('.accordion').each(function(){    // each() 같은 클래스를 따로따로 처리하게 해줌
        let same;       
        let allDt = $(this).find('dt')
        let allDd = $(this).find('dd')

        allDt.css({cursor:'pointer'})

        // allDd.fadeOut();
        allDd.hide();

        allDt.click(function(){

            // allDd.hide();
            // $(this).next().show()

            $(this).next().toggle();

        })

    })

 }) // function(){} END