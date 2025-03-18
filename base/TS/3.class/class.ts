/*
    클래스 정의 :
    - 속성 및 기능의 집합의 정의
*/
class Sample1 {
    field1: string;
    field2?: string;

    constructor(field: string) {
        this.field1 = field;
    }

    method(arg: string): void {}
}

console.log('==================================================');

/*
    접근제어자
    - public: 클래스 내부, 자식, 외부 모든 위치에서 접근 가능
    - protected: 클래스 내부, 자식 클래스에서 접근 가능
    - private: 클래스 내부에서 접근 가능
    - 타입스크립트는 패키지 개념이 없기 때문에 package 제어자가 없음
    - 기본값은 public
*/
class Sample2 {
    public field1: string;
    protected field2: string;
    private field3: string;

    constructor(field1: string, field2: string, field3: string) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }
}

const instance2 = new Sample2('퍼블릭', '프로텍티드', '프라이빗');
console.log(instance2);
console.log(instance2.field1);
// console.log(instance2.field2);
// console.log(instance2.field3);

console.log('==================================================');

/*
    생성자 매개변수에 접근 제어자 지정
    - 생성자의 매개변수에 접근 제어자를 지정하여 필드 선언 가능
*/
class Sample3 {
    constructor(public field1: string, protected field2: string, private field3: string) {}
}

const instance3 = new Sample3('퍼블릭', '프로텍티드', '프라이빗');
console.log(instance3);

console.log('==================================================');

/*
    readonly :
    - readonly가 선언된 클래스 속성은 선언 시 또는 생성자 내부에서만 값을 할당할 수 있음
    - 값을 재할당 할 수 없고 오직 읽기만 가능
    - 상수 선언에 사용
*/
class Sample4 {
    public readonly field1 = '읽기전용1';
    public readonly field2: string;

    constructor(field2: string, public readonly field3: string) {
        this.field2 = field2;
    }

    setMethod() {
        // this.field1 = '변경';
    }
}

const instance4 = new Sample4('값', '값');
// instance4.field1 = '변경';

console.log('==================================================');

/*
    추상 클래스 :
    - 하나 이상의 추상 메서드를 포함하는 클래스, abstract 키워드로 선언
*/
abstract class SuperClass {
    abstract superMethod(arg: string): void;
}

class SubClass extends SuperClass {
    superMethod(arg: string): void {}
}

console.log('==================================================');
