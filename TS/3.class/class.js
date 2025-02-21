/*
    클래스 정의 :
    - 속성 및 기능의 집합의 정의
*/
var Sample1 = /** @class */ (function () {
    function Sample1(field) {
        this.field = field;
    }
    Sample1.prototype.method = function (arg) { };
    return Sample1;
}());
console.log('==================================================');
/*
    접근제어자
    - public : 클래스 내부, 자식, 외부 모든 위치에서 접근 가능
    - protected : 클래스 내부, 자식 클래스
    - private : 클래스 내부에서 접근 가능
    - 타입스크립트는 패키지 개념이 없기에 package 제어자가 없음
    - 기본값은 public
*/
var Sample2 = /** @class */ (function () {
    function Sample2(field1, field2, field3) {
        (this.field1 = field1), (this.field2 = field2), (this.field3 = field3);
    }
    return Sample2;
}());
var instance2 = new Sample2('퍼블릭', '프로텍티드', '프라이빗');
console.log(instance2);
console.log('==================================================');
/*
    생성자 매개변수에 접근 제어자 지정
    -
*/
console.log('==================================================');
/*
    readonly :
    -
    -
    -
*/
console.log('==================================================');
/*
    추상 클래스 :
    -
*/
console.log('==================================================');
