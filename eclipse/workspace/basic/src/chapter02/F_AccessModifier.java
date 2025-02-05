package chapter02;

// 접근 제어자(AccessModifier) : 클래스나 메서드, 필드에 대해서 외부 접근에 대한 제어를 하는 것
// public : 모든 패키지에서 접근 간으
// protected : 같은 패키지 내부 혹은 외부 패키지의 자손 클래스에서 접근 가능
// default(기본값. package라고도 함) : 같은 패키지에서 접근 가능
// private : 같은 클래스에서 접근 가능

class AccessModifierSub1{
	
	void method() {
		F_AccessModifier instanceSub1 = new F_AccessModifier();
		// 같은 패키지 내의 다른 클래스 : public, protected, default
		
		instanceSub1.publicInt=1;
		instanceSub1.defaultInt=1;
		instanceSub1.protectedInt=1;
		// private는 동 클래스 내에서만 사용 가능
//		instanceSub1.privateInt=1;
	}
}

public class F_AccessModifier {

	public int publicInt;
	protected int protectedInt;
	int defaultInt;
	private int privateInt;
	
	public static void main(String[] args) {
		// static 메서드에서 인스턴스 필드를 바로 사용할 수 없음
//		publicInt = 0;
		F_AccessModifier instance = new F_AccessModifier();
		
		// 같은 패키지 내의 같은 클래스 : 전부 다
		instance.publicInt = 0;
		instance.protectedInt = 0;
		instance.defaultInt = 0;
		instance.privateInt = 0;
		
		
		
	}

}
