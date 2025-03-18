/*
    객체 : 키(key)와 값(value)로 구성된 속성들의 집합
    - 함수를 가질 수 있음 (메서드)
*/

/*
    객체 리터럴 : 자바스크립트에서 가장 일반적인 객체 생성 방법
    - {}를 사용하여 객체를 생성
*/
var emptyObj = {};

var hongGildong = {
    name: '홍길동',
    age: 26,
    address: '부산광역시',
    greeting: function () {
        console.log(`안녕하세요. ${this.name}입니다.`);
    },
};
console.log(hongGildong);
console.log(hongGildong.name);
hongGildong.greeting();

var name = '이방원';
var age = 18;
var ho = '태종';

var taejong = {
    name,
    age,
    ho,
};
console.log(taejong);

console.log('==============================');

/*
    Object 생성자 : Object 클래스의 생성자로 빈 객체 생성
*/
var emptyObject = new Object();
console.log(emptyObject);
emptyObject.name = '이재황';
console.log(emptyObject);
emptyObject.name = '이척';
console.log(emptyObject);

console.log('==============================');

/*
    생성자 함수 : 생성자 함수를 사용하여 클래스처럼 사용 가능
*/
function King(name, start, end, ho) {
    this.name = name;
    this.start = start;
    this.end = end;
    this.ho = ho;
}

var saejo = new King('이유', 1455, 1468, '세조');
console.log(saejo);

console.log('==============================');

/*
    속성 이름 (속성 키) : 
    - 일반적으로 문자열로 표기함
    - 자바스크립트에서는 유효한 변수명일 경우 따옴표 생략 가능
    - 유효한 변수명이 아니면 반드시 따옴표를 사용해야함
*/
var human = {
    'first name': '길동',
    'last-name': '고',
    age: 29,
};
console.log(human);

console.log('==============================');

/*
    속성 값 읽기 : 
    - . 표기법과 [] 표기법으로 접근 가능
    - . 표기법은 유효한 이름일 때 사용
    - [] 표기법은 모든 이름에서 사용 가능, 동적인 접근을 가능하게 해줌
    - 객체에 존재하지 않는 속성에 접근하려 하면 undefined 반환
*/
console.log(human.age);
console.log(human['age']);
console.log(human['first name']);

var property = 'last-name';
console.log(human[property]);

console.log('==============================');

/*
    속성 값 변경 :
    - 객체의 속성에 접근하여 새로운 값을 할당하면 변경가능
    - 만약 존재하지 않는 속성에 접근하면 새로운 속성이 생성됨
*/

console.log('==============================');

/*
    속성 삭제 :
    - delete 연산자를 사용하여 속성 제거 가능
*/
delete emptyObject.name;
console.log(emptyObject);

emptyObject.name = undefined;
console.log(emptyObject);

console.log('==============================');

/*
    for-in 문 : 
    - 객체에 포함된 키를 순차적으로 접근할 수 있음
    - 문자열로된 속성의 키가 반환
*/
for (var key in saejo) {
    console.log(saejo[key]);
}

var newSaejo = {};
for (var key in saejo) {
    newSaejo[key] = saejo[key];
}
newSaejo.name = '홍길동';
console.log(newSaejo);
console.log(saejo);

console.log('==============================');
