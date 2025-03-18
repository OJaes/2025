package chapter01;

import java.util.Scanner;

public class F_Control_Switch {
	public static void main(String[] args) {
		
		// switch : 특정 변수 혹은 표현식에 따라 실행할 코드 블럭의 범위를 결정하는 것
//		switch(일반 표현식) {
//		case 값1:
//			일반 표현식이 값1과 같을 때 시작할 코드 블럭 위치
//		case 값2: 
//			일반 표현식이 값2와 같을 때 시작할 코드 블럭 위치
//			switch 내부에서 break문을 만나면 switch 코드 블럭 탈출
//			break;
//		case 값3:
//			일반 표현식이 값3와 같을 때 시작할 코드 블럭 위치
//		default:
//			일반 표현식이 case 값과 일치하는 것이 하나도 없거나
//			바로 위에서 break문을 만나지 않으면 실행되는 코드		
//		}
		
		// number라는 정수형 변수에 사용자로부터 정수를 입력받아서 할당
		// 0이면 A, B, C를 출력
		// 1이면 B, C
		// 2이면 C를 출력
		// 3이면 D, E를 출력
		// 0~3이 아니면 E만 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int number = sc.nextInt();
		
		switch(number) {
		case 0: System.out.print("A, ");
		case 1: System.out.print("B, ");
		case 2: System.out.println("C");
			break;
		case 3: System.out.print("D, ");
		default: System.out.println("E");
		}
		
		
		
		
		
	}
}
