package chapter02;

// JVM : Java Virtual Machine 자바 가상 머신
// 실제 컴파일된 코드를 실행하는 기계
// 별도의 메모리 구조를 가짐

// Method Area (메서드 영역) 
// : 모든 곳에서 접근 가능한 영역, 코드를 읽고 각 클래스의 구조를 저장하고 있음

// Heap Area (힙 영역)
// : 모든 곳에서 접근 가능한 영역, 인스턴스나 배열과 같은 new 연산자를 통해 생성된 객체들이 저장되는 영역

// Stack Area (스택 영역)
// : 각 쓰레드(실행중인 프로세스) 별로 독립적으로 존재하는 영역, 메서드 호출과 로컬 변수에 대한 정보가 저장됨
// 각 코드 블럭마다 하나의 스택이 생성됨. 코드 블럭이 끝나면 스택이 없어짐

class EC2{
	int iv;
	static int cv;
	
	void im() {
		int lv = 10;
		EC2 itc = new EC2();
	}
	
	static void cm () {
		int clv = 10;
	}
}


public class B_JVM {
	
	static void method1(int arg) {
		arg++;
	}
	
	static void method2(EC2 arg) {
		arg.iv++;
	}
	
	
	public static void main(String[] args) {
		
		int lv1 = 20;
		double lv2 = 3.5;
		
		if (lv1 > 0) {
			int cb = 30;
			lv1 = cb;
		}
		
		EC2 itc1 = new EC2();
		EC2 itc2 = new EC2();
		
		itc1.iv = 10;
		itc2.iv = -99;
		
		itc1.cv = 3000;
		itc1.im();
		
		/*
		 * 메서드 영역 	: int iv / int cv / void im(){내용} / int lv / EC2 itc / void cm(){내용} / int clv 저장 / if 조건인 상수 0도 저장됨
		 * 힙 영역	: 스택 3번에서 itc 공간 만들 때 내부에 iv, im 공간 생성 후 주소 할당 - 마찬가지로 itc2 공간 만들고 내부 변수 저장, itc2 주소 할당 - 5번에서 itc 저장하고 주소 할당
		 * 스택 영역	: 1. main 영역 생성 - 4byte(int lv1 = 20) 할당 및 값 20 저장 - 8byte(double lv2 = 3.5) 할당 및 값 3.5 저장 - if문 조건 확인 후 true인 것을 체크
		 * 			  2. if 영역 생성 - 4byte(int cb = 30) 할당 및 값 30 저장 - 위 스택에서 저장된 lv1 값을 cb 값인 30으로 저장 - if 구문이 끝나므로 if 스택 삭제
		 * 			  3. 다시 main 영역만 남음 - itc1 공간 생성(힙 영역의 주소 할당) - itc2 공간 생성(힙 영역에 생성된 주소 할당)
		 * 			  4. (ict1.iv = 10)에서 itc1의 힙 주소를 찾아가서 iv 값 바꾸기 - 마찬가지로 itc2 주소를 따라 힙 영역에서 itc2의 iv 값 바꾸기
		 * 			  5. itc1.cv=3000에서 메서드 영역의 cv 바꾸기(static) - im()호출했으니 스택 영역에 공간을 하나 더 만들어 lv, itc 공간 넣기 - itc도 힙 영역에 들어가니 주소 받아오기
		 * 			  6. itc1.im() 호출이 끝났고, 이를 따로 저장하지 않았으니 itc 영역 삭제. 단, 힙 영역에는 그대로 남음
		 * 
		 * 힙 영역에 인스턴스가 계속해서 쌓이면 메모리 과다 가능성 o
		 * java에서는 가비지 컬렉션으로 어느정도 정리해줌(위 예시의 itc)
		 * 
		 */
		
		
		int a = 99;
		method1(a);
		System.out.println(a);
		
		EC2 b = new EC2();
		System.out.println(b.iv);
		method2(b);
		System.out.println(b.iv);
		
	}
	
	
	
	
}
