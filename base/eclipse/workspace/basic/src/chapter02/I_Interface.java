package chapter02;

// 인터페이스 : 클래스가 구현해야만 하는 메서드들의 집합을 정의해둔 것
// 인터페이스의 모든 변수는 public static final 혀앹
// 인터페이스의 모든 메서드는 public abstract 형태임
// 인터페이스는 다중 구현이 가능함
// 접근제어자 interface 인터페이스명 {...}

// 변수는 항상 public static final이므로 생략해도 됨
// 메소드도 항상 public abstract 형태이므로 생략해도 됨
interface AreaCalculation{
	
	double PI = 3.14;
	
	double getTriangleArea(double bottom, double height);
	double getRectangleArea(double bottom, double height);
	double getCircleArea(double radius);
	
}

// implements 키워드를 사용해 class에서 구현
// 인터페이스는 다중 구현이 가능함
class Calculator implements AreaCalculation, NormalCalculation{

	double bottom;
	double height;
	double radius;
	
	Calculator(double bottom, double height){
		this.bottom = bottom;
		this.height = height;
	}
	
	Calculator(double radius){
		this.radius = radius;
	}
	
	@Override
	public double getTriangleArea(double bottom, double height) {
		return bottom * height / 2;
	}

	@Override
	public double getRectangleArea(double bottom, double height) {
		return bottom * height;
	}

	@Override
	public double getCircleArea(double radius) {
		return radius * radius * PI;
	}

	@Override
	public double add(double a, double b) {
		return a + b;
	}

	@Override
	public double minus(double a, double b) {
		return a - b;
	}
	
}

// 인터페이스끼리는 상속이 가능함
// 인터페이스의 확장(상속)은 다중 상속이 가능함
interface NormalCalculation {
	
	double add(double a, double b);
	double minus(double a, double b);

}

// 이렇게 쓰는 것보다는 CLASS에서 구현을 여러개 하는게 낫다
interface Calculation extends NormalCalculation, AreaCalculation{
	
}


public class I_Interface{
	public static void main(String[] args) {
		
		
		
		
	}
}

// 인터페이스는 개발자간의 상호 약속을 위한 수단으로 사용됨
// 기능, 상수들에 대한 약속을 정의함


