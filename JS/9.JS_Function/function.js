/*
    함수 : 특정한 작업을 수행하기 위해 필요한 구문들의 집합
    - function 함수명(매개변수, ...) { 실행구문... }
    - 동일한 코드를 반복해서 작성하려고 할 때 반복을 제거하여 코드의 재사용성을 높이는 목적
    - 특정 기능이나 코드 구문에 대해서 이름을 부여하는 목적
    - 특정 작업들에 대해서 모듈화를 위한 용도로 사용할 수 있음
*/
function add(a, b) {
    return a + b;
}

var result = add(1, 4);
console.log(result);

/*
    함수 표현식 : 함수도 객체 리터럴 방식으로 정의할 수 있고 변수에 할당할 수 있음
*/
/*
    - 기명 함수 표현식
*/
var f1 = add(1, 2);
var f2 = add;
console.log(f1);
console.log(f2);
console.log(f2(1, 2));

var f3 = function add2(a, b) {
    console.log(a + b);
};
f3(1, 5);
// 기명 함수 형태로 작성한 함수 표현식은 해당 함수명으로 호출이 불가능
// add2(1, 5);

/*
    - 익명 함수 표현식
*/
var f4 = function (a, b) {
    console.log(a + b);
};
f4(10, 20);

/*
    콜백 함수 : 다른 함수의 매개변수로 전달되는 함수
*/
function math(preProcess, a, b) {
    var aa = preProcess(a);
    var bb = preProcess(b);
    console.log(aa + bb);
}

function pre1(number) {
    return number * number;
}

math(pre1, 5, 10);
math(
    function (data) {
        return -data;
    },
    5,
    10
);

function func1() {
    var v = 10;
    return function (data) {
        console.log(v + data);
    };
}

var result = func1();
result(10);

func1()(10);
