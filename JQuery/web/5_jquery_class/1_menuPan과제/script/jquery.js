$(function () {
    
    //TODO
    //개별 메뉴 갯수 더해주기
    //주문버튼 처리

    let menuTd = $('.menus>td')
    let menuImg = menuTd.find('img')

    let listTable = $('#listTable')
    let orderInfo = $('#listtr')


    menuImg.css({ cursor: 'pointer' })

    let menuCount = 1;
    let amountPrice = 0;

    let deleteButton = '<button type="button" class="delete">삭제</button>'

    // 사진 클릭 이벤트
    menuImg.click(function () {
        // alert($(this).siblings('.menuCount').val())
        amountPrice += parseInt($(this).siblings('span').next().attr('value'))

        let tr = $('<tr/>')
        listTable.append(tr)
        tr.append('<td class = "beverage">' + $(this).siblings('span').attr('value') + '</td>')

        //TODO 갯수더해주기
        tr.append('<td class="menuCount">' + menuCount++ + '</td>')
        tr.append('<td>' + deleteButton + '</td>') // 버튼 만들기
    
        $('#total').val(amountPrice)
    })

    // 1-2 select option으로 카운트
    menuTd.find('.menuCount').each(function () {
        $(this).change(function () {
            amountPrice += parseInt($(this).siblings('span').next().attr('value') * $(this).val())

            let tr = $('<tr/>')
            listTable.append(tr)
            tr.append('<td class = "beverage">' + $(this).siblings('span').attr('value') + '</td>')
            tr.append('<td class="menuCount">' + $(this).val() + '</td>')
            tr.append('<td>' + deleteButton + '</td>')

            $('#total').val(amountPrice)
        })
    })

    // 삭제 이벤트 $(this) -> .delete
    listTable.on('click', '.delete', function () {
        let beverage = $(this).parent().siblings('.beverage').text()
        let menuCount =  parseInt($(this).parent().siblings('.menuCount').text())
        let price = $('td:contains('+beverage+')').children().eq(3).text();
        
        menuCount--;
        parseInt($(this).parent().siblings('.menuCount').text(menuCount))
        
        amountPrice -= price

        // 0일때 삭제
        if(menuCount == 0){
            $(this).parent().parent().remove();
        }
        
        
        $('#total').val(amountPrice)

    })

    // 주문처리 이벤트

}) // function(){} END
