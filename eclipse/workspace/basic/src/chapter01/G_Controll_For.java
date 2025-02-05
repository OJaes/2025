package chapter01;

public class G_Controll_For {
	public static void main(String[] args) {
		
		// 반복문 : 특정 조건을 만족하는 동안 지정한 코드 블럭을 반복 실행하도록 하는 것
		
		// for문 : 일반적으로 반복 횟수가 정해져있을 때 사용하는 반복문
		// for (조건에 사용할 변수 초기화; 논리표현식; 변수 증감식){ 반복할 코드 블럭 }
		
		for(int count = 1; count <= 10; count++) {
			System.out.println(count);
			System.out.println("안녕하세요");
		}
		
//		for(int n = 2; n <= 9; n++) {
//			System.out.println("2 * " + n + " = " + (n * 2));
//		}
		
		for(int n = 2; n <= 9; n++) {
			for(int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %d%n", n, j, n*j);
			}
		}
		
		String[] fruits = new String[] {"apple", "grape", "pineapple", "banana", "kakao"};
		for(int idx = 0; idx < fruits.length; idx++) {
			fruits[idx] += " add";
		}
		for(int idx = 0; idx < fruits.length; idx++) {
			System.out.println(fruits[idx]);
		}
		
		// for-each : 컬렉션(배열)의 각 요소를 하나씩 변수에 복사해서 사용하는 반복문
		// for (배열요소의타입 변수명 : 배열) { 반복할 코드 블럭 }
		// for-each는 컬렉션의 실제 요소에 대해서 읽기 전용 작업에 적합
		// 변경하는 작업을 수행할 때는 적합하지 않음
		for(String fruit : fruits) {
			fruit += " plus";
			System.out.println(fruit);
		}
		// 여기서 변경된 것은 복사된 변수이므로 기존 배열에 적용되지 않음
		for(String fruit : fruits) {
			System.out.println(fruit);
		}
		
		
		
		
	}
}
