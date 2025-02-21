/*
    인터페이스 : 
    - 클래스 및 객체의 타입으로 사용됨
    - 인터페이스에 선언된 속성 또는 메서드의 구현을 강제
    - interface 키워드로 선언
*/

/*
    변수(객체)의 타입으로써 인터페이스
*/
interface King {
    name: string;
    ho: string;
    age: number;
}
interface Human {
    name: string;
    age: number;
    address: string;
}

const taejo: King = {
    name: '이성계',
    ho: '태조',
    age: 74,
};

const jeongjong: Human = {
    name: '이방과',
    age: 63,
    address: '고려',
};

interface King2 extends Human {
    name: string;
    ho: string;
    age: number;
}

interface Human2 extends King {
    name: string;
    age: number;
    address: string;
}

interface KingHuman extends King, Human {}

const taejong: King & Human = {
    name: '이방원',
    ho: '태종',
    age: 58,
    address: '고려',
};
console.log('==================================================');

/*
    클래스의 타입으로써 인터페이스
*/
interface IMath {
    add: (x: number, y: number) => number;
}

class CMath implements IMath {
    add(x: number, y: number) {
        return x + y;
    }
}
console.log('==================================================');

/*
    선택적 속성 :
    - ? 키워드로 클래스나 인터페이스(객체)의 속성을 선택적으로 구현하도록 할 수 있음
*/

interface King3 {
    name: string;
    ho?: string;
    birth: string;
    death?: string;
}

const saejong: King3 = {
    name: '이도',
    birth: '1397-05-15',
};
saejong.ho = '세종';
saejong.death = '14500-04-08';
console.log('==================================================');
