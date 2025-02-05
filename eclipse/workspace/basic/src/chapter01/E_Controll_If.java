package chapter01;

public class E_Controll_If {
	public static void main(String[] args) {
		
		// 코드 블럭
		// statement의 집합
		// 코드들의 묶음(여러 구문을 하나의 묶음(기능)으로 취급)
		// {}로 표시
		{
			int a = 10;
			int b = 20;
			int result = a + b;
			System.out.println(result);
		}
		// 코드블럭 내부의 변수는 외부에 존재하지 않는 것과 같음
		
		// System.out.println(a);
		int a = 0;
		
		{
			// int a = 1;
			// 코드 블럭은 main 메소드와 종속적인 관계임
			// 즉 main의 변수는 코드 블럭 내에서 사용할 수 있으나 상위로의 인용은 불가능함
			int b = 0;
		}
		
		// 제어문 : 조건에 따라서 코드의 흐름을 결정하는 것
		// 조건문 : 특정 조건이 만족하면 해당 코드 블럭을 실행하는 것
		
		// if문 : 주어진 논리표현식(조건)이 true이면 코드 블럭을 실행하게 하는 것
		// if (condition) { condition이 true일 때 실행할 코드 블럭 }
		
		System.out.println("if문 시작");
		
		int number = 10;
		
		if (number > 0) {
			System.out.println("양수");
		}
		
		System.out.println("if문 종료");
		
		// else문 : if문의 논리 표현식이 false일 때 코드 블럭을 실행하게 하는 것
		// if (condition) {true 일 때 실행할 코드 블럭}
		// else { false일 때 실행할 코드 블럭 }
		
		// 주의!
		// 1. else 문은 반드시 if문 이후에 와야함.
		// 2. else 문에는 논리 표현식을 작성하지 않음
		
		System.out.println("if-else문 실행");
		 number = -5;
		if (number > 0) {
			System.out.println("양수");
		} else {
			System.out.println("양수가 아님");
		}
		System.out.println("if-else문 종료");
		
		System.out.println("여러 조건");
		number = 0;
		if (number > 0) 
		{
			System.out.println("양수");
		} 
		else 
		{
			if (number < 0) 
			{
				System.out.println("음수");
			}
			else
			{
			System.out.println("0");
			}
		}
		if (number > 0) System.out.println("양수");
		else if (number < 0) System.out.println("음수");
		else System.out.println("0");
		// 구문이 모두 한 줄이므로 블럭을 풀어도 된다
		// else는 if에 종속되므로 마찬가지로 하나의 구문이다.
		
		System.out.println("여러 조건 종료");
		
		
		System.out.println("논리 연산 조건");
		
		// 국적, 나이, 성별
		// 대한민국, 성인(> 19), 남성
		
		String country = "대한민국";
		int age = 23;
		String gender = "남성";
		
//		if(country == "대한민국" && age > 19 && gender == "남성") System.out.println("입영통지서");
//		else System.out.println("면제");
		
//		if(country.equals("대한민국") && age > 19 && gender.equals("남성")) System.out.println("현역");
		
		// 클린 코딩
		boolean isActive = country.equals("대한민국") && gender.equals("남성") && age > 19;
		if(!isActive) return;
		System.out.println("현역");
		

	}
}
