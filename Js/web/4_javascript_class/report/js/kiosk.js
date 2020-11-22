let orderCount = 0; // 주문번호
let amountPrice = 0; // 총 금액
let menuMap = new Map();

window.onload = function () {
    let textPrice = document.getElementById('amountPrice')
    let type = document.querySelectorAll('.type')
    let menu = document.querySelectorAll('.menu') // 세트메뉴
    let menuImg = document.querySelectorAll('.menuImg') // 메뉴이미지 세팅
    let menuName = document.querySelectorAll('.menuName')
    let orderCon = document.getElementById('orderCon') // 메뉴확인란
    let cancel = document.getElementById('cancel') // 주문 취소
    let order = document.getElementById('order')   // 주문

    let burgerList = new Array('기네스콰트로치즈와퍼', '칠리크랩통새우', '몬스터와퍼', '콰트로치즈와퍼',
                            '트러플머쉬룽와퍼', '통새우와퍼', '베이컨치즈와퍼', '불고기와퍼', '와퍼')
    let beverageList = new Array('코카콜라', '코카콜라 제로', '스프라이트', '씨그램', '미닛메이드 오렌지', '순수[미네랄워터]', '핫초코', '아이스초코', '컵 아이스크림')
    let setPriceList = new Array('9700', '9000', '8800', '8700', '8400', '8500', '6100', '5500', '5200') // 세트메뉴 가격
    let burgerPriceList = new Array('6700', '6000', '5800', '5700', '5400', '5500', '3100', '2500', '2200')
    let beveragePriceList = new Array('1500', '1500', '1500', '2000', '2000', '1000', '1200', '1200', '900')

    let choiceMenu = null;
    let price = 0;
    let menuCount = 1;

    // 시작화면
    for (let set = 0; set < menu.length; set++) {


        menuImg[set].src = 'img/set' + [set + 1] + ".png"
        menu[set].setAttribute('name', burgerList[set] + " 세트")
        menu[set].setAttribute('price', setPriceList[set])
        menuName[set].innerHTML = menu[set].getAttribute('name') + "-" + menu[set].getAttribute('price') + "원";
        menu[set].onclick = function () {
            choiceMenu = menu[set].getAttribute('name')
            price = menu[set].getAttribute('price')

            if (menuMap.has(choiceMenu)) {
                menuMap.set(choiceMenu, (menuMap.get(choiceMenu)+1))
            } else {
                menuMap.set(choiceMenu, 1)
            }

            orderCon.append(choiceMenu + " " + price + "원 \n")

            amountPrice += parseInt(price) // 주문 총액
            textPrice.innerHTML = amountPrice + "원"

            cancel.onclick = function () {  // 취소버튼 클릭 이벤트
                orderCon.innerHTML = ""
                textPrice.innerHTML = ""
                menuCount = 1;
                amountPrice = 0;
                menuMap.clear()
            }
            order.onclick = function () {   // 주문버튼 클릭 이벤트
                menuCount = 1;
                orderCount++;
                console.log("주문번호 : " + orderCount + ", 총 금액 : " + amountPrice)
                orderCon.innerHTML = ""
                textPrice.innerHTML = "총 금액"
                amountPrice = 0;
                menuMap.clear();
            }
        }

    }

    for (let typeNo = 0; typeNo < type.length; typeNo++) {
        type[typeNo].onclick = function () {
            if (typeNo == 0) {  // 세트 화면
                for (let set = 0; set < menu.length; set++) {

                    menuImg[set].src = 'img/set' + [set + 1] + ".png"
                    menu[set].setAttribute('name', burgerList[set] + " 세트")
                    menu[set].setAttribute('price', setPriceList[set])
                    menuName[set].innerHTML = menu[set].getAttribute('name') + "-" + menu[set].getAttribute('price') + "원";

                    menu[set].onclick = function () {
                        choiceMenu = menu[set].getAttribute('name')
                        price = menu[set].getAttribute('price')

                        if (menuMap.has(choiceMenu)) {
                            menuMap.set(choiceMenu, (menuMap.get(choiceMenu)+1))
                        } else {
                            menuMap.set(choiceMenu, 1)
                        }

                        orderCon.append(choiceMenu + " " + price + "원 \n")

                        amountPrice += parseInt(price) // 주문 총액
                        textPrice.innerHTML = amountPrice + "원"
                    }
                }
            } else if (typeNo == 1) {   // 단품 화면
                for (let set = 0; set < menu.length; set++) {

                    menuImg[set].src = 'img/burger' +[set+1]  + ".png"
                    menuImg[5].src = 'img/burger06.png'

                    menu[set].setAttribute('name', burgerList[set])
                    menu[set].setAttribute('price', burgerPriceList[set])

                    menuName[set].innerHTML = menu[set].getAttribute('name') + "-" + menu[set].getAttribute('price') + "원";

                    menu[set].onclick = function () {
                        choiceMenu = menu[set].getAttribute('name')
                        price = menu[set].getAttribute('price')
                        if (menuMap.has(choiceMenu)) {
                            menuMap.set(choiceMenu, (menuMap.get(choiceMenu)+1))
                        } else {
                            menuMap.set(choiceMenu, 1)
                        }

                        orderCon.append(choiceMenu + " " + price + "원 \n")

                        amountPrice += parseInt(price) // 주문 총액
                        textPrice.innerHTML = amountPrice + "원"
                    }
                }
            } else if (typeNo == 2) {
                for (let set = 0; set < menu.length; set++) {
                    menuImg[set].src = 'img/beverage' + [set + 1] + ".png"
                    menu[set].setAttribute('name', beverageList[set])
                    menu[set].setAttribute('price', beveragePriceList[set])
                    menuName[set].innerHTML = menu[set].getAttribute('name') + "-" + menu[set].getAttribute('price') + "원"
                    menu[set].onclick = function () {
                        choiceMenu = menu[set].getAttribute('name')
                        price = menu[set].getAttribute('price')

                        if (menuMap.has(choiceMenu)) {
                            menuMap.set(choiceMenu,(menuMap.get(choiceMenu)+1))
                        } else {
                            menuMap.set(choiceMenu, 1)
                        }

                        orderCon.append(choiceMenu + " " + price + "원 \n")

                        amountPrice += parseInt(price) // 주문 총액
                        textPrice.innerHTML = amountPrice + "원"
                    }
                }
            }
            cancel.onclick = function () {  // 취소버튼 클릭 이벤트
                orderCon.innerHTML = ""
                textPrice.innerHTML = ""
                menuCount = 1;
                amountPrice = 0;
                menuMap.clear()
            }
            order.onclick = function () {   // 주문버튼 클릭 이벤트
                menuCount = 1;
                orderCount++;
                console.log("주문번호 : " + orderCount + ", 총 금액 : " + amountPrice)
                orderCon.innerHTML = ""
                textPrice.innerHTML = "총 금액"
                amountPrice = 0;
                menuMap.clear();
            }
        }
    }
}
