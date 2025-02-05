package chapter03;

import java.util.InputMismatchException;
import java.util.Scanner;

// 에러 : 주로 프로그램에서 복구할 수 없는 심각한 문제
// 자원 부족이 큰 원인을 차지함
// 개발자가 대처할 수 없는 수준의 에러

// - 컴파일 에러 :; 소스 코드의 문법을 준수하지 않았을 때 발생
// 1. 문법 오류(세미 콜론 등의 잘못된 사용)
// 2. 타입 불일치: 변수나 메서드의 타입이 일치하지 않을 때
// 3. 미선언 변수 : 선언하지 않은 변수나 메서드, 클래스를 사용하려 할 때

// - 런타임 에러 : 프로그램 실행 중에 발생
// 1. 외부와의 연결 실패
// 2. 라이브러리 버전 불일치

// 예외 : 프로그램이 정상적으로 실행중인 상태에서 발생할 수 있는 예상치 못한 상황
// 에러는 발생 시 프로그램 실행 자체가 안됨 / 예외는 정상적으로 실행 된 상태에서 발생
// 예외는 개발자가 직접 처리 및 예방할 수 있음	

public class A_ErrorAndException {
	
	// throws : 메서드의 호출부에 예외처리에 대한 강제성을 부여
	
	private static void exceptionMethod() throws Exception {
		// throw : 강제로 예외를 발생시키는 키워드
		// throw new 예외클래스("메시지")
		throw new NullPointerException("Null 예외");
		
	}
	
	public static void main(String[] args) {
		// 예외 처리 방법
		// try-catch 구문을 사용하여 처리 가능
		
		// try { 예외가 발생할 수 있는 구문 }
		// catch(예외클래스 변수) { 특정 예외가 발생하면 실행할 구문 }
		
		Scanner sc = new Scanner(System.in);
		
		double first, second;
		
		try {
			System.out.print("첫 번째 숫자 : ");
			first = sc.nextDouble();
			// 예외 발생 가능 위치
			
			System.out.print("두 번째 숫자 : ");
			second = sc. nextDouble();
			
			// 예외 발생 가능 위치
		} catch (Exception exception) {
			exception.printStackTrace();
			System.out.println("숫자만 입력하세요.");
			return;
		}finally {
			// finally : 예외 발생에 상관없이 실행할 코드
			// 대부분 자원 반납을 명시할 때 사용
			sc.close();
		}
		
		double addingResult = first + second;
		double subtractionResult = first - second;
		double multiplicationResult = first * second;
		double divisionResult = first / second;
		
		System.out.println("덧셈 결과 : " + addingResult);
		System.out.println("뺄셈 결과 : " + subtractionResult);
		System.out.println("곱셈 결과 : " + multiplicationResult);
		System.out.println("나눗셈 결과 : " + divisionResult);
		
		sc.close();
		try {
			exceptionMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 예외 발생 시 프로그램 중지
		System.out.println("연산이 완료되었습니다");
	}
}
