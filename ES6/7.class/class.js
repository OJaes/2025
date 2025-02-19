/*
    클래스 정의 : class 키워드로 클래스 정의
    - constructor 생성자를 이용해서 멤버변수 선언  및 초기화 가능
    - 생성자에서 this를 사용하여 멤버 변수를 지정할 수 있음
    - new 연산자로 인스턴스 생성 가능능
*/
// 왕 클래스 : 이름 / 묘호(호) / 생일 / 사망일
class King {
    constructor() {
        this.name = '이성계';
        this.ho = '태조';
        this.birth = '1335-11-04';
        this.death = '1408-06-27';
    }
}

const taejo = new King();
console.log(taejo);

console.log('==================================================');

/*
    constructor: 
    - 인스턴스를 생성하고 클래스의 필드를 초기화하는 용도로 사용되는 특수 메서드 (생성자)
    - 생성자 안에서 this 키워드로 클래스 멤버 변수를 선언 및 초기화할 수 있음
    - 생성자의 매개변수로 각 속성의 값을 받아와서 초기화
    - js의 생성자는 오버로딩 안됨
*/

class King {
    constructor(name, ho, birth, death) {
        this.name = name;
        this.ho = ho;
        this.birth = birth;
        this.death = death;
    }
}

const jeongjong = new King('이방과', '정종', '1357-07-26', '1419-10-15');
console.log(jeongjong);

console.log('==================================================');

/*
    클래스의 필드 선언  : 퍼블릭 - 프라이빗 / 인스턴스 - 클래스
    - 인스턴스 퍼블릭 필드
    - 인스턴스 프라이빗 필드
    - 클래스 퍼블릭 필드
    - 클래스 프라이빗 필드
*/

class Sample1 {
    // 인스턴스 퍼블릭 필드
    publicField;
    // 인스턴스 프라이빗 필드
    #privateField;
    // 클래스 퍼블릭 필드
    static staticPublicField;
    //클래스 퍼블릭 필드
    static #staticPrivateField;

    constructor() {
        this.publicField = '퍼블릭';
        this.#privateField = '프라이빗';
        // 클래스 변수는 this.으로 접근 불가능
        // 아래와 같이 작성하면 인스턴스 변수로 생성됨
        // this.staticPublicField;
    }
}
const instance1 = new Sample1();
console.log(instance1);
// console.log(instance1.#privateField);
Sample1.staticPublicField = '스태틱';
console.log(Sample1.staticPublicField);

console.log('==================================================');

/*
    getter, setter : 
    - getter : 프라이빗 멤버 변수의 값을 얻을 수 있는 캡슐화 메서드
    - setter : 프라이빗 멤버 변수의 값을 설정할 수 있는 캡슐화 메서드드
*/

class Sample2 {
    #privateField;

    constructor(privateField) {
        this.#privateField = privateField;
    }

    set privateField(privateField) {
        this.#privateField = privateField;
    }
}

const instance2 = new Sample2('프라이빗');
console.log(instance2);
console.log(instance2.privateField);
instance2.privateField = '변경 프라이빗 필드';
console.log(instance2.privateField);

console.log('==================================================');

/*
    인스턴스 메서드와 정적 메서드 : 
    - 클래스 내부에서 function 키워드 없이 함수를 작성하여 인스턴스 메서드 선언
    - static 키워드를 추가하여 클래스 메서드를 선언
*/

class Sample3 {
    instanceField;
    static classField;

    instanceMethod() {
        console.log('인스턴스 메서드');
    }

    static classMethod() {
        console.log('클래스 메서드');
    }
}

const instance3 = new Sample3();
instance3.instanceMethod();
// instance3.classMethod();
// console.log(instance3.classField);
Sample3.classMethod();

console.log('==================================================');

/*
    클래스 상속 : 
    - extends 키워드를 사용하여 클래스 상속
    - 오버로딩은 안되지만 오버라이딩은 가능
    - super 키워드로 부모 클래스 참조 가능
*/

class ParentClass {
    parentField;

    constructor(parentField) {
        this.parentField = parentField;
    }

    parentMethod() {
        console.log('부모메서드');
    }
}

class ChildClass extends ParentClass {
    childField;

    constructor(parentField, childField) {
        super(parentField);
        this.childField = childField;
    }

    childMethod() {
        console.log('자식메서드');
    }
}

const childInstance = new ChildClass('부모', '자식');
console.log(childInstance);
childInstance.childMethod();
childInstance.parentMethod();
