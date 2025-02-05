package chapter03;

import java.util.Date;

// 어노테이션 : 코드에 메타데이터를 추가하는 방법, 
// 툴 도는 프레임워크에 특정 코드를 어떻게 해석해야 하는지에 대한 정보를 제공
// 컴파일러에게 코드 작성의 의도를 알릴 수 있음
// 실행 시 특정 코드가 어떻게 동작하는지 지정할 수 있음

// 기본적인 어노테이션
// @Override : 지정한 메서드가 상위 클래스의 메서드를 오버라이드 하는 메서드임을 컴파일러에 명시
// @Deprecated : 지정한 메서드가 더 이상 사용되지 않음을 컴파일러에 명시
// @SuppressWarning : 컴파일 경고를 무시하도록 함

class Over{
	void method() {
		
	}
}

// 커스텀 어노테이션 : @interface를 이용하여 어노테이션을 직접 생성할 수 있음
@interface CustomAnnotation{
	String value() default "";
}

@CustomAnnotation
public class H_Annotation extends Over{
	
	@Override
	void method() {
		super.method();
	}
	
	/**
	 * @param arg
	 */
	
	@Deprecated
	static void deprecated() {}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int variable;
		
		deprecated();
//		Date date = new Date(2025,0,7);
		
		
	}
}
