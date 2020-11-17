
// 삼각형의 폭과 높이 프라퍼티를 가진 객체 선언
var MyArea = function(base, height) {
  this.base = base;
  this.height = height;
};

// prototype에 메소드 정의
MyArea.prototype = {
  getTriangle : function() {
    return this.base * this.height / 2;
  },
  getSquare : function() {
    return this.base * this.height;
  }
};
