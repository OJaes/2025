import React, { ChangeEvent, KeyboardEvent, MouseEvent } from 'react';
import { setConstantValue } from 'typescript';

// 이벤트 처리:
// - 웹 페이지(컴포넌트)가 사용자와의 상호작용을 받아들여 그것에 대해 처리하는 것
// - React에서는 addEventListener 함수를 채용하지 않고 인라인 방식을 사용함
// - 이유 : 코드 재사용성, [html, js, css] 간의 종속성이 높으므로 이를 줄이기 위함
// - 인라인에 이벤트 핸들러 속서은 전부 lowerCamelCase를 따름
// - 이벤트 핸들러에는 콜백 함수를 전달

export default function EventComponent() {
    // onClick : 클릭 발생할 때 이벤트
    // onKeyDown : 키보드를 눌렀을 때
    // onChange : 요소의 값을 변경했을 때

    const onClickHandler = (event: MouseEvent<HTMLButtonElement>) => {
        alert('클릭!');
    };

    const onKeyDownHandler = (event: KeyboardEvent<HTMLInputElement>) => {
        const { key } = event;
        alert(`누른 키 : ${key}`);
        // alert('키보드를 눌렀습니다.');
    };

    // onChange의 경우 HTML에서는 onInput + onChange를 합해놓은 것
    const onChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
        const { value } = event.target;
        alert(`입력한 내용 : ${value}`);
        // alert('값이 변경되었습니다.');
    };

    const employees = [
        {
            name: '홍길동',
            employeeNumber: '202501',
        },
        {
            name: '이성계',
            employeeNumber: '202502',
        },
    ];

    // 이벤트 처리 콜백 함수로 매개변수가 event만 받는 형태가 아니라면
    // 직접적으로 함수를 전달하여 사용할 수 없음음
    const onEmployeeNameClickHandler = (employeeNumber: string) => {
        alert(`사원번호 : ${employeeNumber}`);
    };

    let count = 0;
    const onIncreaseHandler = () => {
        count++;
        alert(count);
    };

    return (
        <div>
            <button onClick={onClickHandler}>클릭</button>
            <input placeholder="키보드" onKeyDown={onKeyDownHandler} />
            <input placeholder="변경" onChange={onChangeHandler} />
            <div>
                {employees.map((employee, index) => (
                    <div key={index}>
                        <h2 onClick={() => onEmployeeNameClickHandler(employee.employeeNumber)}>{employee.name}</h2>
                    </div>
                ))}
            </div>
            <div>
                {count} <button onClick={onIncreaseHandler}>증가</button>
            </div>
        </div>
    );
}
