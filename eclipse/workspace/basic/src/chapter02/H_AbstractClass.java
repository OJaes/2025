package chapter02;

// 추상 클래스 : 추상 메서드를 포함할 수 있는 클래스
// 추상 클래스 자체로는 인스턴스를 생성할 수 없음
// 반드시 추상 클래스를 상속받은 하위 클래스에서 인스턴스를 생성해주어야 한다
// abstract 제어자(키워드) 사용
// abstract class 클래스명 { ... }

// 추상 메서드 : 선언부만 존재하고 구현부는 존재하지 않는 메서드
// 반드시 클래스 중에서는 추상 클래스 내부에서만 선언할 수 있음
// 추상 클래스를 상속받은 하위 클래스에서 추상 메서드를 오버라이딩 후 구현해야 함
// abstract 반환타입 추상메서드명 (매개변수);

// abstract : 추상 클래스, 메서드를 정의하는 제어자
// abstract가 붙은 클래스는 인스턴스(객체)를 생성할 수 없음
// abstract가 붙은 메서드는 구현부를 가질 수 없음(오버라이딩 해야함)

abstract class Occupation/*직업군*/ {
	int annual;
	int income;
	
	// 추상클래스에서 생성자는 인스턴스를 생성하는 목적이 아님
	// 하위 클래스에서 호출하여 사용할 수 있도록 제공하는 목적
	// 단, 기본 생성자가 없는 상태에서 생성자를 정의한다면
	// 하위 클래스에 생성자 작성을 강제함
	Occupation(int annual, int income) {
		this.annual = annual;
		this.income = income;
	}
	
	// 추상 메서드는 하위 클래스에서 오버라이딩을 강제함
	abstract void work();

	// 추상 클래스도 일반 메서드를 가질 수 있음
	// 일반 메서드는 오버라이딩을 강요하지 않음
	void sleep() {
		System.out.println("잠을 잡니다");
	}
}

// 추상 클래스도 단일 상속만 가능
class Developer extends Occupation{
	
	Developer(int annual, int income, String position) {
		super(annual, income);
		this.position = position;
	}

	String position;
	
	void eat(String food) {
		System.out.println(food + "을 먹습니다");
	}
	
	@Override
	void work() {
		System.out.println("프로그램을 개발합니다");
	}
	
}

class TourGuide extends Occupation{

	TourGuide(int annual, int income, String country) {
		super(annual, income);
		this.country = country;
	}

	String country;
	
	@Override
	void work() {
		System.out.println(country + "에서 관광을 설명합니다");
	}
	
	@Override
	void sleep() {
		System.out.println(country + "에서 잠을 잡니다");
	}
	
}

// 제어자 조합
// static이 붙은 변수 : public + static + final (자주 사용)
// private + final이 붙은 변수 : 생성자에서 필수로 초기화해야 함을 의미
// private + final이 붙은 메서드 : final이 의미가 없음
// private + abstract가 붙은 메서드 : 모순임(해당 클래스에서만 사용 가능한 private + 하위 클래스에서 오버라이드 해야만 하는 abstract)
// final + abstract가 붙은 클래스와 메서드 : 마찬가지로 모순임(오버라이드를 막는 final + 오버라이드 해야만 하는 abstract)


public class H_AbstractClass {

	public static void main(String[] args) {

//		Occupation occupation = new Occupation(10, 100);
		
		Developer developer = new Developer(10, 100, "백엔드");
		TourGuide guide = new TourGuide(1, 20, "한국");
		
		developer.work();
		System.out.println(guide.annual);
		
		
		
		
		
		
		
		

	}

}
