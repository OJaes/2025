import React from 'react';
import { useLocation, useSearchParams } from 'react-router';

export default function QueryString() {
    // useLocation()로 반환되는 location 객체에 search 속성 값으로 query string을 구할 수 있음
    // search 속성은 query가 문자열로 받아 사용성이 떨어짐.
    // const { search } = useLocation();
    // console.log(search);

    // useSearchParams() :
    // = URL에서 Query String 값을 받을 수 있도록 하는 react-router 훅 함수
    // - 반환 [getQueryString, setQueryString]
    const [queryPrams] = useSearchParams();

    const name = queryPrams.get('name');
    const age = queryPrams.get('age');
    return (
        <div>
            나이 : {age}, 이름 : {name}
        </div>
    );
}
