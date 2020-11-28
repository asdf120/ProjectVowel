$(function () {

    //TODO
    //개별 메뉴 갯수 더해주기
    //주문버튼 처리

    let menuTd = $('.menus>td')
    let menuImg = menuTd.find('img')

    let listTable = $('#listTable')

    menuImg.css({ cursor: 'pointer' })

    let amountPrice = 0;

    let deleteButton = '<button type="button" class="delete">삭제</button>'

    // 사진 클릭 이벤트
    menuImg.click(function () {
        let beverage = $(this).siblings('span').attr('value')   // 선택한 이미지의 음료 이름
        let count = $('#listTable td:contains(' + beverage + ')').next()    // 주문목록에 있는 해당 음료의 갯수
        beverageCount = count.text();

        // 주문한 메뉴가 메뉴목록에 있는경우 갯수만 증가
        if ($('#listTable td:contains(' + beverage + ')').text() == beverage) {
            count.text(++beverageCount)
        } else {    // 주문한 메뉴가 주문목록에 없는경우
            let tr = $('<tr/>')
            listTable.append(tr)
            tr.append('<td class = "beverage">' + beverage + '</td>')
            tr.append('<td class="menuCount">' + 1 + '</td>')
            tr.append('<td>' + deleteButton + '</td>') // 버튼 만들기
        }

        amountPrice += parseInt($(this).siblings('span').next().attr('value'))
        $('#total').val(amountPrice)
    })

    // 1-2 select option으로 카운트
    menuTd.find('.menuCount').each(function () {
        $(this).change(function () {
            let beverage = $(this).siblings('span').attr('value')
            let count = $('#listTable td:contains(' + beverage + ')').next()
            beverageCount = parseInt(count.text());

            if ($('#listTable td:contains(' + beverage + ')').text() == beverage) {
                beverageCount += parseInt($(this).val());
                count.text(beverageCount)
            } else {
                let tr = $('<tr class = "menuTr"/>')
                listTable.append(tr)
                tr.append('<td class = "beverage">' + $(this).siblings('span').attr('value') + '</td>')
                tr.append('<td class="menuCount">' + $(this).val() + '</td>')
                tr.append('<td>' + deleteButton + '</td>')
            }
            amountPrice += parseInt($(this).siblings('span').next().attr('value') * $(this).val())
            $('#total').val(amountPrice)
        })
    })

    // 삭제 이벤트 $(this) -> .delete
    listTable.on('click', '.delete', function () {
        let beverage = $(this).parent().siblings('.beverage').text()    // 주문목록에 있는 음료이름
        let menuCount = parseInt($(this).parent().siblings('.menuCount').text())    // 주문목록에 있는 음료의 갯수
        let price = $('.menus>td:contains(' + beverage + ')').children().eq(3).attr('value');   // 메뉴판에 있는 메뉴의 가격

        menuCount--;    // 메뉴갯수 1개씩 차감
        parseInt($(this).parent().siblings('.menuCount').text(menuCount))   // 차감한 메뉴 주문목록에 보여줌

        // 0일때 삭제
        if (menuCount == 0) {
            $(this).parent().parent().remove();
        }

        amountPrice -= price
        $('#total').val(amountPrice)
    })

    // 주문처리 이벤트
    $('#btn').click(() => {
        alert('주문 성공')
        amountPrice = 0
        $('#listTable tr').slice(3).remove();   // 전체 주문 목록 삭제
        $('#total').val(amountPrice)
    })

}) // function(){} END
