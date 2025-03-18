package chapter02;

// 오버로딩(Overloading) : 같은 클래스 내부에서 같은 이름의 메서드를 여러 개 작성할 수 있도록 하는 방법론
// 오버로딩 조건
// 1. 메서드의 이름을 중복해서 작성하고 매개변수타입의 조합(개수, 순서)을 다르게 작성
// 2. 메서드의 반환타입과 매개변수의 이름은 영향을 주지 않음
class NewMath{
	 public int add(int a, int b) {
	        return a + b;
	    }

	 // 문제점
	 // 1. 메서드의 이름이 불규칙적임
	 // 2. 사용시에 불편을 초래함
	 double add2(double a, double b) {
		 return a + b;
	 }
	 
	 // 오버로딩 : 매개변수의 타입을 다르게 한 경우
	 double add(double a, double b) {
		 return a + b;
	 }
	 
	 // 오버로딩 : 매개변수의 개수를 다르게 한 경우
	 int add(int a, int b, int c) {
	      return a + b + c;
	 }
}

public class C_Overloading {

	public static void main(String[] args) {
		
		NewMath newMath = new NewMath();
		newMath.add(4, 8);
		newMath.add(1, 2, 3);
		newMath.add(1.5, 3.5);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
