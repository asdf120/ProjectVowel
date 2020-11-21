
// window.onload = function(){	
document.addEventListener('DOMContentLoaded', function() {
		
  var list = document.getElementById('list');
  var pic = document.getElementById('pic');
  var del = document.getElementById('del');

  // 리스트에서 선택(클릭했을 때)
  list.onclick = function(event){
    console.log("ㅇㅋ")
    let isbn = event.target.getAttribute('data-isbn')
    //<img src = '경로' width='100' height='70'>
    let img = document.createElement('img')
    img.width=150;
    img.height = 150;
    img.src = './images/' + isbn + '.jpg';

    if(pic.getElementsByTagName('img').length>0){
      pic.replaceChild(img,pic.firstChild) // 1개이기때문에 firstChild나 lastChild 같은결과
    }else{
      pic.appendChild(img)
      del.disabled = false; // 삭제버튼 활성화
    }

  }
  // 삭제 버튼 누르면 pic 아래 자식(img 태그)를 지운다

  del.onclick = function(){
    pic.removeChild(pic.firstChild);
    del.disabled=true;
  }
  
  
  
  
//};
});