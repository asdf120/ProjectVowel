$(function () {

    //1.날짜 나타내기
    let today = new Date();
    $('span.year').text(today.getFullYear())
    $('span.month').text(today.getMonth() + 1)
    $('span.date').text(today.getDate())

    // 2. 검색어 포커스 처리 
    $('input#keyword').focus(function () {
        $(this).css({
            background: "none"
        })
    })
    $('input#keyword').blur(function () {
        $(this).css({
            background: 'url(images/sch_guide.gif) no-repeat'
        })
    })

    // 3.탭팬 구현
    let tabImg = $('#tabmenu a>img')
    let curImg = $('#tabmenu a>img:eq(0)')

    tabImg.click(function () {
        let choiceImg = $(this) // 현재 선택한 탭

        $('#tabmenu>dd').css({  // 전체 이미지를 일단 다 안보이게함
            display: 'none'
        })
        // 선택되어있는 공지사항을 선택안한걸로 바꿈
        curImg.prop('src', curImg.prop('src').replace('over', 'out'))
        // 선택한 탭 선택한걸로 보이게함
        $(this).prop('src', $(this).prop('src').replace('out', 'over'))

        // 선택한 탭 dd 보이게함
        choiceImg.parent().parent().next().css({
            display: 'block'
        })
        curImg = choiceImg
    })
    $('img[alt="더보기"]').click(function () {
        $('#tabmenu>dd:eq(0)').css({  // 전체 이미지를 일단 다 안보이게함
            display: 'block'
        })
    })




    // 4.로그인 창
    $('.login_wrap>a>img').click(function () {
        $('#login_f').css({
            left: '-110px',
            top: '30px'
        });
    })
    // 5.로그인 닫기
    $('.login_close_btn img').click(function () {
        $('#login_f').css({
            left: '-110px',
            top: '-500px'
        });
    })

    // 북 슬라이더
    $('#best_bg>ul').bxSlider({
        slideMargin: 50,
        slideWidth: 'content',
        auto: true,
        moveSlides: 2,
        speed: 300
    });

    // 전체메뉴
    $('#total_btn img').click(function () {
        $('#total_menu').slideDown();
        $('#total_menu').css({
            display: 'inline-block',
        })

    })
    // 전체메뉴 닫기
    $('#total_close').click(function () {
        $('#total_menu').css({
            display: 'none'
        })
    })


}) // function(){} END
