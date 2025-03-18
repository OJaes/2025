/* 
    데이터 타입

    원시 타입
    - number
    - string
    - boolean
    - null
    - undefined
    - symbol

    객체 타입
    - object
*/

/*
    number : 정수 및 실수를 모두 포함하는 타입
*/
var integer = 10;
var float = 10.0;

/* 
    - number 타입의 값들은 표기법만 다르고 값은 같을 수 있음
*/
console.log(integer == float);

/*
    Infinity : 양의 무한대
    -Infinity : 음의 무한대
    NaN : 숫자가 아님
*/

var x = Infinity;
x = -Infinity;
x = NaN;
console.log(10 / 0);
console.log(10 * '십');

/*
    string : 문자열 텍스트 타입
    - '', "", ``으로 문자열 리터럴 표현 가능
    - 일반적으로 javascript에서는 ''로 문자열을 표기
*/
var name_ = '홍길동';
name_ = '홍길동';
name_ = `홍길동`;

/*
    - javascript의 문자열은 인덱싱으로 각 문자에 접근할 수 있음 (유사 배열)
*/
for (var index = 0; index < name_.length; index++) {
    console.log(name_[index]);
}

// javascript의 문자열은 불변성을 가지고 있음
name_[0] = '고';
console.log(name_);

/*
    boolean : 논리 참, 거짓을 나타냄
    - 빈문자열(''), null, undefined, 0은 false로 간주됨
*/
var statement = '';
if (statement) {
    console.log('true 입니다.');
}

/*
    undefined : 선언 이후에 값을 초기화하지 않은 변수는 undefined를 가짐
    - 선언은 했지만 초기화하지 않은 변수
    - *객체 내에 존재하지 않는 속성
*/
var age;
console.log(age);
var obj = { name: '홍길동', age: 23 };
console.log(obj.address);

/*
    null : 의도적으로 변수에 값이 아직 지정되지 않았음을 명시
    - 변수에 저장된 메모리를 제거하는 용도
    - 함수의 반환값으로 유효한 값이 없을 때 반환하는 용도
    - null 값을 typeof 연산자로 확인하면 object라는 타입이 반환됨
*/
obj = null;
console.log(typeof obj);
