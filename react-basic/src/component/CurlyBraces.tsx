import React from 'react';

export default function CurlyBraces() {
    // Curly Braces:
    // - JSX 에서 자바스크립트 표현식을 작성할 대 사용하는 방법
    // - JSX 안에 { }로 영역을 지정하여 그 안에 자바 스크립트 표현식을 작성

    const title = 'Curly Braces';
    const arr = ['apple', 'banana', 'cacao'];
    const object = {
        name: '이성계',
        ho: '태조',
        age: '73',
    };
    // 1. 요소의 컨텐츠에 자바스크립트의 표현식 결과를 사용하고자 할 때
    // 2. 주석 처리 - JSX에서는 HTML 주석을 사용할 수 없으므로 JS 주석을 사용해야 함
    // 3. 속성의 값을 지정할 때
    //      - JSX에서 인라인 스타일은 문자열 X, 객체로 표현
    // 4. 배열은 각 요소를 나열하면서 렌더링이 되지만, 객체는 직접 렌더링할 수 없음(하나씩 가능)
    // 5. 선언문, 제어문을 사용할 수 없음음

    return (
        <>
            <h1 style={{ backgroundColor: 'black', color: 'white' }}>제목 : {title}</h1>
            <div>1 + 2 = {1 + 2}</div>;
            <table>
                <tr>
                    <td rowSpan={2}></td>
                </tr>
            </table>
            <div>{arr}</div>
            <div>{object.name}</div>
        </>
    );
}
