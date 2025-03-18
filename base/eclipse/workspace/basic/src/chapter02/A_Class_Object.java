package chapter02;

import java.lang.invoke.VarHandle.AccessMode;

// 클래스 : 공통된 속성과 기능을 정의
// [접근 제어자] class 클래스명 { 속성, 기능 }

class ExampleClass1 {
	
	// 속성 : 객체가 가지는 정보나 상태의 정의
	// 일반적으로 변수 형태로 표현
	int attribute1;
	double attribute2;

	// 인스턴스 변수 : 각 인스턴스마다 독립적으로 값을 가지는 변수
	// 인스턴스가 생성된 후에 사용 가능
	int instanceVariable;
	
	// 클래스 변수 : 해당 클래스로 생성된 모든 인서턴스가 공유하는 변수
	// 필드 데이터 타입 앞에 static 키워드 사용하여 지정
	// 인스턴스 생성 없이 사용 가능
	static int classVariable;
	
	// 기능 : 객체가 가질 수 있는 행동이나 작업(메서드)
	// [접근자] 반환타입 메서드명 (매개변수타입 매개변수명,...)             - 메서드의 선언부
	// { 메서드 기능 구현 } 										 - 메서드의 구현부
	void method() {
		System.out.println("method");
		// return : 메서드의 겨로가를 반환하는 역할
		// 일반적인 메서드는 반드시 제일 마지막에 return이 필수
		// void 메서드에서는 필수가 아님
		// 메서드 중간에서 조건문 등을 활용해 강제 메서드 종료에도 사용됨
		return;
	}
	
	// 인스턴스 메서드 : 인스턴스 생성 후 인스턴스를 통해 호출 가능한 메서드
	// 인스턴스, 클래스 변수 및 메서드를 모두 사용 가능
	int instanceMethod1 (int arg1) {
//		return arg1 * attribute1;
		return arg1 * classVariable;
	}
	
	// 클래스 메서드 : 인스턴스 생성없이 클래스로 호출 가능한 메서드
	// 반환타입 앞에 static 키워드를 붙여서 선언 가능
	// 클래스 메서드에서는 인스턴스 변수 사용 및 인스턴스 메서드 호출이 불가능
	// 인스턴스 변수 및 인스턴스 메서드를 사용하지 않는 기능에 주로 사용됨
	static int classMethod1 (int arg1) {
		return arg1 * classVariable;
	}
	
}


// 스마트폰
// - 운영 체제
// - 전화번호
// - 전원상태
// - 전원 상태 변경
// - 정보를 보여주는 작업
// - 전화를 거는 작업

class SmartPhone1 {
	String os;
	String telNumber;
	boolean power;
	
	void onOff() {
		power = !power;
	}
	
	void printInfo() {
		if(!power) {
			System.out.println("power is off");
			return;
		}
		System.out.println("OS : " + os);
		System.out.println("Tel Number : " + telNumber);
	}
	
	void tel(String number) {
		if(!power) {
			System.out.println("전원이 꺼져있습니다");
			return;
		}
		System.out.println(telNumber + "으로 " + number + "에게 전화를 겁니다");
	}
	
	
}


// 삼각형 관련 수학
// 빗변 구하기
// 둘레 구하기
// 너비 구하기
class TriangleMath {
	// SPPED_OF_LIGHT 변수는 클래스의 단일 책임 법칙에 위배됨
//	final static int SPEED_OF_LIGHT = 300_000_000;
	
	static double getHypotenusedouble (double bottom, double height) {
		if(bottom <= 0 || height <= 0) return 0; 
		double hypotenuse2 = Math.pow(bottom,  2) + Math.pow(height, 2);
		double hypotenuse = Math.sqrt(hypotenuse2);
		return hypotenuse;
	}
	
	static double getCircumference(double bottom, double height,double hypotenuse) {
		if(bottom<=0 || height <= 0 || hypotenuse <= 0) {
			return 0;
		}
		return bottom + height + hypotenuse;
	}
	
	static double getArea(double bottom, double height) {
		if (bottom <= 0 || height <= 0) {
			return 0;
		}
		double area = bottom * height / 2;
		return area;
	}
}


public class A_Class_Object {

	// 함수 : 특정 기능에 대한 정의
	// 반환타입 함수명 (매개변수타입 매개변수명, ...) { 기능 코드 블럭 }
	private static int fx1(int x) {
		return ((x * x) + (2 * x) + 1);
		// return : 함수를 종료하며 함수 결과를 반환하는 역할
		// 함수에서 반드시 return 작업이 수행되어야 함
		// 단, void 반환타입 일 때는 return이 필수는 아님
		// void : 타입 없음
	}
	
	// 함수의 목적
	// 1. 기능을 미리 정의해두고 사용할 땐 호출하여 사용할 수 있도록 함
	//    (코드 중복 제거, 유지 보수성 향상, 실제 구현내용을 알 필요 없음)
	// 2. 기능에 이름을 보여하여 사용할 수 있도록 함
	
	
	public static void main(String[] args) {
		
		// 인스턴스 : 특정 클래스로 정의된 것을 실체화한 것
		// 클래스명 참조변수명 = new 클래스명(매개변수);
		
		ExampleClass1 instance1 = new ExampleClass1();
		ExampleClass1 instance2 = new ExampleClass1();
		System.out.println(instance1);
		System.out.println(instance2);
		// 값 할당은 되지만 주소를 알 수 없음.
//		new ExampleClass1().attribute1 = 1;

		// 인스턴스가 가지고 있는 속성 접근 방법
		// 인스턴스명.속성명
		
		ExampleClass1.classVariable = 20;
		instance1.classVariable = 99;
		
		System.out.println(instance1.classVariable);
		System.out.println(instance2.classVariable);
		System.out.println(ExampleClass1.classVariable);
		
		// 클래스 변수 사용할 때 주의할 점
		// 클래스 변수는 모든 인스턴스에 영향을 미치기 때문에
		// 클래스로 접근하길 권장함
		// 일반적으로 클래스 변수는 final 키워드와 함께 사용
		
		
		SmartPhone1 iPhone16 = new SmartPhone1();
		SmartPhone1 galaxy24 = new SmartPhone1();
		
		iPhone16.os = "iOS";
		iPhone16.telNumber = "010-1234-5678";
		
		galaxy24.os = "Android";
		galaxy24.telNumber = "010-9876-5432";
		
//		System.out.println(iPhone16.os);
//		System.out.println(galaxy24.os);
		
//		System.out.println(iPhone16.telNumber + "가");
//		System.out.println("010-2222-2222로 전화를 겁니다");
//		
//		System.out.println(galaxy24.telNumber + "가");
//		System.out.println("010-5555-2222로 전화를 겁니다");
		
		// 인스턴스가 가지고 있는 메서드 호출 방법
		// 인스턴스.메서드명(매개변수);
		iPhone16.printInfo();
		iPhone16.onOff();
		iPhone16.printInfo();
		iPhone16.tel(galaxy24.telNumber);
		
		System.out.println(fx1(10));
		System.out.println(fx1(4));
		
		printBmi(84,184,183);
		
		
		double doubleResult = TriangleMath.getHypotenusedouble(4, 3);
		System.out.println(doubleResult);
	}

	private static void printBmi(double a, double b, double c) {
		System.out.println(a / (b * c));
		return;
	}
	
}
