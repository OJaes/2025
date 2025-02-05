package chapter02_sub;

// 다른 패키지의 클래스를 사용하기 위해 import
import chapter02.F_AccessModifier;

public class AccessModifierSub2 {
	
	F_AccessModifier instance = new F_AccessModifier();
	// public으로 지정되지 않은 class는 import 불가
//	AccessModifierSub1 instance2 = new AccessModifierSub1();
	
	// 그냥 다른 패키지에서 사용 = public
	void method() {
		instance.publicInt=0;
		
	}
	
}
// public class는 자기 파일 이름과 같은 것만 가능함
// 각 java 파일에는 반드시 하나의 public class만 가질 수 있음.
class AccessModifierSub3 extends F_AccessModifier{
	// 다른 패키지의 자손 클래스에서 접근 가능 = protected, public
	void method() {
		super.publicInt = 0;
		super.protectedInt = 0;
		
	}
}