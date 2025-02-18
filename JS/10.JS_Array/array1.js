/*
    배열 : 여러 데이터를 하나의 변수에 저장하고자 할 때 사용
*/

/*
    배열 리터럴 : 
    - 0개 이상의 값을 쉼표로 구분하여 []로 묶어 표현
    - 배열[인덱스]로 요소에 접근 가능, 존재하지 않는 인덱스에 접근하면 undefined 반환
    - 각 요소의 데이터 타입이 모두 달라도 됨
*/
var emptyArray = [];
console.log(emptyArray, typeof emptyArray, emptyArray[0]);

var numbers = [1, 2, 3, false, '5'];
console.log(numbers);

var funcs = [
    function () {
        console.log('함수1');
    },
    function () {
        console.log('함수2');
    },
];

funcs[0]();

console.log('==============================');

/*
    배열의 요소 추가
    - 배열[인덱스] = 값 : 요소 추가 가능, 지정한 인덱스에 값이 존재하면 수정
    - 뛰어넘은 인덱스 값에는 empty 요소가 추가됨
*/
emptyArray[2] = 10;
console.log(emptyArray, emptyArray[0]);

console.log('==============================');

/*
    배열의 요소 삭제
    - delete 연산자를 사용하여 제거
*/
delete emptyArray[2];
console.log(emptyArray);

console.log('==============================');

/*
    배열의 순회
    - for-in 방식을 이용하여 index 값을 가지고 순회 가능
*/
var fruits = ['apple', 'banana', 'cacao'];
for (var index = 0; index < fruits.length; index++) {
    console.log(fruits[index]);
}
for (var index in fruits) {
    console.log(fruits[index]);
}

console.log('==============================');

/*
    - for-in 방식은 index를 사용하여 한번 더 접근을 해야하기 때문에 단순히 읽는 작업에 대해서는 적합하지 않을 수 있음
    - for-of 방식을 사용하여 배열의 요소를 복사해서 직접 사용할 수 있음
*/
for (var fruit of fruits) {
    console.log(fruit);
}

console.log('==============================');

/*
    배열의 길이 : 배열.length
*/

// var newFruits = fruits;
// newFruits[0] = '사과';
// console.log(fruits);

var newFruits = [];
// for (var index = 0; index < fruits.length; index++) {
//     newFruits[index] = fruits[index];
// }
// for (var index in fruits) {
//     newFruits[index] = fruits[index];
// }
for (var fruit of fruits) {
    newFruits.push(fruit);
}

newFruits[0] = '사과';
console.log(newFruits);
console.log(fruits);

console.log('==============================');

/*
    배열 메서드
*/

/*
    indexOf(element) : 
    - 배열에 매개변수로 전달한 요소가 존재한다면 첫번째 인덱스 값을 반환
    - 존재하지 않으면 -1을 반환
*/
console.log(fruits.indexOf('apple'));
console.log(fruits.indexOf('melon') !== -1);

console.log('==============================');

/*
    includes(element) :
    - 배열에 전달된 매개변수가 요소에 존재하면 true, 존재하지 않으면 false를 반환
*/
console.log(fruits.includes('apple'));
console.log(fruits.includes('melon'));

console.log('==============================');

/*
    push(element) :
    - 배열의 마지막 인덱스에 요소를 추가하고 변경된 길이를 반환
*/
console.log(fruits, fruits.length);
console.log(fruits.push('mango'), fruits);

console.log('==============================');

/*
    pop() :
    - 배열의 마지막 요소를 제거하고 제거한 요소를 반환
*/
console.log(fruits.pop(), fruits);

console.log('==============================');

/*
    shift() :
    - 배열의 첫번째 요소를 제거하고 제거한 요소를 반환
*/
console.log(fruits.shift(), fruits);

console.log('==============================');

/*
    reverse() :
    - 배열의 요소 순서를 역전
*/
var numbers = [1, 2, 3, 4, 5, 6];
console.log(numbers.reverse(), numbers);

console.log('==============================');

/*
    concat(array or item) : 
    - 매개변수로 전달된 값들을 배열의 마지막 요소 뒤에 연결하여 새로운 배열을 반환
*/
var newNumbers = numbers.concat([1, 2, 3]);
console.log(newNumbers, numbers);

console.log('==============================');

/*
    slice(start, end) : 
    - start에 해당하는 인덱스부터 end에 해당하는 인덱스까지 복사하여 반환
*/
console.log(numbers.slice(2, 4), numbers);

console.log('==============================');

/*
    splice(start, eleteCount, items...) :
    - 배열의 요소를 제거하고 제거한 위치에 요소를 갈아끼운 배열을 반환
*/
console.log(numbers.splice(1, 2, '추가', '추가2'), numbers);
console.log(numbers.splice(1, 1), numbers);
