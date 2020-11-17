// describe('name', specs )  : 테스트명과 테스트케이스
describe('Jasmine의 기본', function() {
  var area;

  // 테스트 케이스가 실행되기 전
  beforeEach(function() {
    area = new MyArea(10, 5);
  });

  // 테스트 케이스가 처리 된 후 
  afterEach(function() {
  });

  //************  개별 테스트 케이스
  it('getTriangle메소드의 테스트', function() {
    expect(area.getTriangle()).toEqual(25);	// 동일한가
  });

//************  개별 테스트 케이스
  it('getSquare메소드의 테스트', function() {
    expect(area.getSquare() === 50).toBeTruthy(); // true인가
  });
});