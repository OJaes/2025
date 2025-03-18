package chapter02;

// 상속 : 객체지향 프로그래밍의 특성 중 하나
// 원래 존재하던 클래스를 '확장'하여 재사용할 수 있도록 하는 것
// 코드의 중복을 제거하여 코드 재사용성, 유지보수성, 확장성을 높일 수 있음
// extends 키워드를 사용

// class SubClassName extends SuperClassName { ... }

class Human {
	String name;
	int age;
	
	public Human() {}
	
	// 부모 클래스의 생성자는 상속되지 않음
	Human(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	void sleep() {
		System.out.println(name + " : zzZ");
	}
	
	final void eat() {
		System.out.println("밥을 먹습니다.");
	}
}

class Korean extends Human{

	static String country = "Korea";
	
	Korean(String name, int age) {
		super(name, age);
	}

	
	void sleep() {
		System.out.println("01시에 잠을 잔다");
	}
}

// 상속은 하나의 클래스에서만 받을 수 있음. 단일 상속만 지원함
// 상속을 단계별로 해야함
// 다중 상속에 발생할 수 있는 다이아몬드 문제가 발생하지 않도록 하기 위함
// 다이아몬드 문제 : 다중 상속으로 인해 동일한 이름의 메서드를 상속 받은 상태에서 어떤 메서드를 선택해야 할지 모호해지는 문제
// 인터페이스를 사용해 다중 상속 효과를 볼 수 있음
// 중첩 상속을 사용해 다중 상속 효과를 볼 수 있음
class FireFighter extends Korean /* Human */{
	
	FireFighter(String name, int age) {
		// super : this처럼 부모클래스의 생성자를 호출
		super(name, age);
	}

//	String name;
//	int age;
	String position;
	int time;
	
//	void sleep() {
//		System.out.println(name + " : zzZ");
//	}

	// Human 클래스에서 상속받은 sleep 메서드를 오버로딩 한 것
	// 오버로딩(매개변수가 다름)
	void sleep(int time) {
		System.out.println(name + "이 " + time + "시에 잠을 잔다");
	}
	
	
	void fireFight() {
		System.out.println("불을 진압한다");
	}
}

class PoliceOfficer extends Human{
	
	PoliceOfficer() {
		// super() : 부모 클래스의 생성자를 지칭하느 ㄴ키워드
		super("이향",32);
		// super : 부모 클래스를 지칭하는 키워드
//		super.name = "이향";
//		age = 32;
		rank = "경감";
	}
	
	PoliceOfficer(String name, int age) {
		super(name, age);
		}

//	String name;
//	int age;
	String rank;
	
//	void sleep() {
//		System.out.println(name + " : zzZ");
//	}
	
	void patrol() {
		System.out.println("순찰을 돈다");
	}
}

// Java의 모든 클래스는 Object를 최상위 클래스로 상속받는다

class SalesMan extends Human{
	int sales;
	
	void sale(int amount) {
		sales += amount;
	}
	// 오버라이딩 (Overriding) : 하위 클래스에서 상위 클래스의 메서드를 '재정의' 하는 것
	// 규칙
	// 1. 상위 클래스에서 선언된 메서드와 이름, 매개변수 조합, 반환 타입이 같아야함
	// 2. 상위 클래스에서 선언된 메서드가 final로 선언되면 재정의할 수 없음
	
	// @Override : 컴파일러에게 현재 작업이 오버라이딩 작업임을 알려줌(문법 검사 실행)
	@Override
	void sleep() {
		// 오버라이딩을 통해 코드의 유연성을 증가시킬 수 있음
		System.out.println("영업 사원이 잠을 잔다");
		// 코드의 재사용성을 높이는 방법
//		System.out.println(name + "이 잠을 잔다");
		super.sleep();
	}
}

final class FinalSuper{
	int a;
}

// final 클래스는 상속받을 수 없다
// system과 같은 클래스들(final class의 메서드는 굳이 final을 붙일 필요가 없음)
//class FinalSub extends FinalSuper{
//	
//}

public class E_Inheritance{

	public static void main(String[] args) {
		FinalSuper sp = new FinalSuper();
		sp.a = 1;
		
		FireFighter fireFighter = new FireFighter("이도",35);
		fireFighter.name = "이도";
		System.out.println(fireFighter.name);
		
		PoliceOfficer police = new PoliceOfficer();
		police.sleep();
		fireFighter.sleep();
		
		SalesMan salesMan = new SalesMan();
		salesMan.sleep();
		
		salesMan.eat();
		
		
		
		
	}

}
