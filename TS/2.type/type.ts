/*
    타입선언 : 
    - 변수 및 함수에 타입을 지정하여 타입에 대한 제한을 추가할 수 있음
*/
let variable: number;
variable = 10;
// variable = '10';

let numbber = 10;
// number = '10';

function func1(arg: string, arg2: number): string {
    return '';
}

function func2(arg: string): void {}

/*
    typescript의 타입
    - string : 문자열
    - number : 숫자
    - boolean : 논리
    - null : null타입
    - undefined : 정의되지 않음
    - object : 객체
    - array : 배열
    - enum : 열거형
    - void : 반환값 없음
    - any : 모든 타입
*/
const numbers: number[] = [1, 2, 3];
const numbers2: Array<number> = [1, 2, 3];

// ts에는 참조형이 아닌 원시형 string도 있음
let str1: string = 'string';
let str2: String = 'String';

// 단, 원시형에 참조형을 넣을 수는 없고, 반대는 가능함
str2 = str1;
// str1 = str2;

enum Color {
    RED = '#ff0000',
    GREEN = '#00ff00',
    BLUE = '#0000ff',
}

const color: Color = Color.RED;

let anyType: any = 10;
anyType = '10';

const funcType: (arg: string) => string = (arg: string): string => {
    return '';
};
/*
    타입추론 :
    - 타입을 선언하지 안혹변수에 값이 초기화 되는 순간에 초기화된 데이터의 타입으로 결정되는 것
*/

let str = '문자열';

/*
    타입 변환 :
    - as 키워드로 형변환 가능(객체일 때 자주 사용), <>연산자로 형변환 가능
*/

const PI: any = '3.14';
let pi: string = PI;

/*
    유니온 타입
    - 복수의 타입을 지정하는 방법
*/
let union: string | number;
union = 10;
union = '10';
// union false;

const func3 = (): string | number => {
    const a = 10;
    if (a > 0) return '양수';
    else if (a < 0) return '음수';
    else return 0;
};

const object: {
    name: string;
    age: number;
} = {
    name: '이성계',
    age: 25,
};

/*
    리터럴 타입
    - 지정한 리터럴만 가질 수 있는 타입
*/

let day: 'am' | 'pm';
day = 'am';
day = 'pm';
