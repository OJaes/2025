/*
    배열 고차 함수
    - 배열의 불변성을 최대한 보장하여 부수 효과를 제거한 메서드
    - 각종 배열을 이용하여 자주 사용되는 편리한 기능들을 제공
*/
const array = [7, 11, 20, 1, 8, 3, 16, 2, 19, 9, 10, 4, 13, 12, 14, 17, 15, 5, 18, 6];

/*
    sort(콜백 함수) : 배열의 요소를 정렬
    - .sort() 로 정렬하면 사전식 정렬이 이루어짐
*/
array.sort();
console.log(array);

// 오름차순 정렬을 위한 함수
var asc = function (x, y) {
    return x - y;
};
array.sort(asc);
console.log(array);

// 내림차순 정렬을 위한 함수
array.sort(function (x, y) {
    return y - x;
});
console.log(array);

console.log('==============================');

/*
    forEach(콜백 함수) : for 문 대신 사용
    - 배열을 순회하면서 각 요소와 인덱스를 사용할 수 있도록 함
    - 원본 배열 변경 X
    - break, continue 등 일반 반복문에서 사용되는 부수작을 수행할 수 없음
    - for문 보다 성능이 많이 떨어짐, 가독성이 좋고 편리해서 사용
    - async await 작업은 forEach 메서드로 사용 불가능
*/
array.forEach(function (element, index) {
    console.log(`index : ${index} / element : ${element}`);
});

console.log('==============================');

/*
    map(콜백 함수) : 콜백 함수의 반환값들로 이루어진 새로운 배열 생성해서 반환
    - 원본 배열 변경 X
    - forEach는 단순히 요소나 인덱스를 가지고 작업만 수행 (return X)
    - map은 요소나 인덱스를 가지고 작업한 결과물을 반환 (return O)
*/
var mapArray = array.map(function (element, index) {
    return element * index;
});
console.log(mapArray);

var newArray = array.map(function (element, index) {
    return element;
});
newArray[0] = 99;
console.log(array);
console.log(newArray);

console.log('==============================');

/*
    filter(콜백 함수) : 콜백 함수의 반환값이 true인 배열의 요소의 값만 추출하여 새로운 배열을 생성
    - 배열의 특정 경우만 필터링 조건으로 추출해서 새로운 배열을 만들고 싶을 때 사용
    - 원본 배열 변경 X
*/
var array3 = array.filter(function (element, index) {
    return element % 3 === 0;
});
console.log(array3);

console.log('==============================');

/*
    find(콜백함수) : 콜백 함수의 결과가 true인 첫번째 요소를 반환
*/
var result = array.find(function (element, index) {
    return element % 7 === 0;
});
console.log(result);

console.log('==============================');

/*
    findIndex(콜백함수) : 콜백 함수 결과가 true인 첫번째 요소의 인덱스를 반환
*/
var result = array.findIndex(function (element, index) {
    return element % 7 === 0;
});
console.log(result);

console.log('==============================');
