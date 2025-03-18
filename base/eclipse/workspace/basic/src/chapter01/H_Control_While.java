package chapter01;

import java.util.Scanner;

public class H_Control_While {
	public static void main(String[] args) {
		
		// while문 : 반복할 횟수가 결정되어있지 않을 때 사용하는 반복문
		// 조건이 true인 동안 반복, 조건이 false가 되면 반복을 종료
		// while (논리 표현식) { 논리 표현식이 true일 때 반복할 코드 블럭 }
		
		// 사용자로부터 입력받은 정수를 모두 더해 출력
		// 만약 사용자가 양수가 아닌 값을 입력하면 총합을 출력 후 프로그램 종료
		Scanner sc = new Scanner(System.in);
		
//		int sum = 0;
//		int number = 0;
//		System.out.print("정수 : ");
//		number = sc.nextInt();
//
//		while(number > 0) {
//			sum += number;
//			System.out.print("정수 : ");			
//			number = sc.nextInt();
//		}
//		System.out.println("총합 : " + sum);
		
		// do-while : 위에서 보면 중복으로 쓰이는 코드가 있는데, 일단 한번 실행하게 하고, 그 다음부터 반복 실행하는 것. 단, 잘 쓰이지 않으니 패스
		
		// continue : 반복문에서 continue 만나면 코드 블럭의 끝으로 넘어감
		// break : 반복문에서 break 만나면 탈출
		// continue, break는 조건문과 같이 사용됨
		
//		while(sum > 0) {
//			continue;
//			// System.out.println(sum);   - unreachable code : continue로 인해 실행되지 않을 코드
//		}
		
		
		int sum = 0;
		int number = 0;
		
		while(true) {
			System.out.print("정수를 입력하세요 : ");
			number = sc.nextInt();
			if(number <= 0) break;
			if(number % 2 != 1) continue;
			sum += number;
		}
		System.out.println("총 합계 : " + sum);
		
		// while문 사용할 때는 무한 루프에 주의할 것
		
		
	}
}
