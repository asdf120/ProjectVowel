window.onload = function () {

    var frm = document.getElementById('frm');
    var inputs = document.querySelectorAll("input");

    frm.onsubmit = function(event)
    {
        // event.stopPropagation();
        // event.preventDefault();
        if(!frm.agree.checked){
            alert('반드시 확인')
             return false; //1. 다음화면으로 안넘어가게하기
            // event.preventDefault();
        }
        return true;
        frm.submit();
    }
}