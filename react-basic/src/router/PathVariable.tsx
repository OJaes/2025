import React from 'react';
import { useParams } from 'react-router';

export default function PathVariable() {
    // useParams():
    // - 경로 변수에 해당하는 값을 읽을 수 있도록 하는 react-router 훅 함수
    // - 해당 경로의 경로 변수를 객체로 반환
    const { name, age } = useParams();
    console.log(name);
    console.log(age);

    return (
        <div>
            이름 : {name}, 나이 : {age}
        </div>
    );
}
