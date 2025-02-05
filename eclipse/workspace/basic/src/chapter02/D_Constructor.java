package chapter02;

import java.util.Arrays;

// 생성자(Constructor) : 클래스 인스턴스가 생성되는 순간에 호출되는 메서드
// 클래스와 같은 이름을 가지며, 반환 타입은 존재하지 않음
// 클래스명(매개변수) { 인스턴스가 생성될 때 수행할 작업 }

class Human1 {
	String name;
	int age;
	String gender;
	
	// 상수가 있고 초기화가 되지 않았을 경우
	// 생성자는 반드시 상수를 초기화해야 한다
	// 즉, 필수 값(required)
	final String ADDRESS;
	
	// nums 배열은 주소가 저장되므로 이것 역시 참조형이다
	int[] nums;
	
	// 만약 다른 생성자(매개변수가 존재하는 생성자)만 존재한다면
	// 기본 생성자는 자동으로 제공되지 않음
	Human1 () {
		// 1. 인스턴스 생성 시 특정 작업을 수행하고 싶을 때
		System.out.println("Human1의 인스턴스 생성");
		// 2. 인스턴스를 생성과 동시에 인스턴스를 초기화하고 싶을 대
		// 의존성을 내부에서 주입
		name = "홍길동";
		age = 20;
		gender = "남";
		ADDRESS = "부산";
	};
	
	Human1(String name){
		// this : 현재 자기 자신의 인스턴스를 지칭하는 키워드
		// 인스턴스 변수나 인스턴스 메서드를 정확히 지칭할 때 사용
		// this() : 클래스의 다른 생성자를 호출하는 키워드
		// 반드시 생성자에서만 사용 가능
		// 생성자의 제일 첫 구문으로 들어와야 함
		this();
		this.name = name;
//		ADDRESS = "부산";
	}

	
	// 의존성을 모두 외부에서 주입하는 행위
	Human1 (String name, int age, String gender) {		
		System.out.println("Human1의 인스턴스 생성");
		this.name = name;
		this.age = age;
		this.gender = gender;
		ADDRESS = "부산";
		nums = new int[] {1,2,3};
	};
	
	// 주소 복사가 아닌 값만 복사
	// 깊은 복사
	Human1 (Human1 human){
		this.name = human.name;
		this.age = human.age;
		this.gender = human.gender;
		this.ADDRESS = human.ADDRESS;
//		this.nums = human.nums;
		this.nums = Arrays.copyOf(human.nums, human.nums.length);
	}
	
	void printInfo(){
		System.out.println("이름 : " + this.name);
		System.out.println("나이 : " + this.age);
		System.out.println("성별 : " + this.gender);
	}
}

public class D_Constructor {
	
	public static void main(String[] args) {

		// 만약 클래스에 생성자를 정의하지 않으면
		// 컴파일러가 자동으로 기본 생성자를 제공함
		Human1 human1 = new Human1();
		human1.name = "이성계";
		human1.age = 60;
		human1.gender = "남";
		
		Human1 human2 = new Human1();
		System.out.println(human2.name);
		
		Human1 human3 = new Human1("이성계");
		
		Human1 human4 = new Human1("이방과", 30, "여");
		human4.printInfo();
		
		// 참조형 매개변수이므로 주소 복사(독립적이지 않음)
		// 얕은 복사가 이루어짐
		// Human1 human5 = human4;
		
		// 새 주소를 생성하여 값을 복사하는 형태(독립적)
		Human1 human5 = new Human1(human4);
		
		human4.nums[0] = 99;
		
		System.out.println(human4.nums[0]);
		System.out.println(human5.nums[0]);
		
	}

}
