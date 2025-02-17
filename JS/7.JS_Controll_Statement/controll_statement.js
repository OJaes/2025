/*
    if else 문
    - 조건식이 true일 때 if 문의 코드 블럭을 실행, false면 else 문의 코드 블럭 실행
    - 조건식 위치에 논리 표현식이 아니어도 사용 가능
*/
var age = 10;
if (age > 19) {
    console.log('성인');
} else {
    console.log('미성년자');
}

console.log('==============================');
var statement = '내가 그린 기린 그림은';
if (statement) {
    console.log('입력된 구문 : ' + statement);
}

console.log('==============================');

/*
    - if else 문을 삼항 연산자로 변경하여 사용가능
*/
statement ? console.log('입력된 구문 : ' + statement) : null;

console.log('==============================');

/*
    switch 문
    - 표현식을 비교해서 값이 표현식과 일치하면 해당하는 case문으로 실행순서를 지정
    - 표현식과 일치하는 값이 없으면 default 문으로 이동 (default 문이 있을 경우)
    - break 문을 지정하지 않으면 끝까지 진행
*/
var day = 2;
switch (day) {
    case 0:
        console.log('일요일');
    case 1:
        console.log('월요일');
        break;
    case 2:
        console.log('화요일');
    default:
        console.log('다른 요일');
}

console.log('==============================');

/*
    for 반복문
    - 반복할 횟수가 정해져있을 때 사용하는 반복문
*/
var dan = 3;
for (var count = 1; count <= 9; count++) {
    console.log(`${dan} * ${count} = ${dan * count}`);
}

console.log('==============================');

/*
    while 반복문
    - 조건 검사를 먼저하고 반복문을 실행하는 while 문
    - 반복할 횟수가 결정되지 않았을 때 사용하는 반복문
*/
var random = Math.random();
console.log(random);
while (random > 0.3) {
    random = Math.random();
    console.log(random);
}

console.log('==============================');

/*
    do-while 반복문
    - 반복할 코드를 먼저 실행하고 조건 검사를 하는 while문
*/
var random = 0;
do {
    random = Math.random();
    console.log(random);
} while (random > 0.3);

console.log('==============================');

/*
    break 문 
    - switch 혹은 반복문에서 코드 블럭을 강제로 탈출하고자 할 때 사용
*/
while (true) {
    console.log('반복중~~~');
    break;
}

console.log('==============================');

/*
    continue 문
    - 반복문에서 코드 블럭의 맨 마지막으로 커서를 이동
*/
for (var number = 0; number < 10; number++) {
    if (number % 2 === 1) continue;
    console.log(number);
}
