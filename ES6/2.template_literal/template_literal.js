/*
    템플릿 리터럴 : 
    - 문자열 표현을 ``을 이용하여 표현하는 방식
    - + 연산자를 사용하여 연결하지 않고 인터플레이션이라는 ${}형태로 표현식 삽입 가능
*/

const king = {
    number: 1,
    name: '이성계',
    ho: '태조',
};

console.log(`조선의 ${king.number}대 왕 ${king.ho}의 이름은 ${king.name}입니다.`);
