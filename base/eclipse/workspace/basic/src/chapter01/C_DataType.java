package chapter01;

public class C_DataType {
	public static void main(String[] args) {
		
		// 변수의 데이터 타입
		// 기본형 데이터 타입, 참조형 데이터 타입
		
		// 기본형 데이터 타입
		
		// 정수형 데이터 타입 : 실수부가 존재하지 않음, 부호를 가지고 있음
		
		// byte : 1 byte(8bit)의 크기를 가지는 정수형 데이터 타입
		// -128 ~ 127
		byte byte1 = 100;
		// byte byte2 = 128;
		
		// short : 2byte(16bit)의 크기를 갖는 정수형 데이터 타입
		// -32,768 ~ 32,767
		short short1 = 30000;
		// short short2 = 40000;
		
		// int : 4byte(32bit)의 크기를 갖는 정수형 데이터 타입
		// -2,147,483,648 ~ 2,147,483,647 대충 21억
		int int1 = 40000;
		// int int2 = 2200000000;
		// int int2 = 2_200_000_000L; //- ,대신 _ 사용 가능
		
		// long : 8byte(64bit)의 크기를 가지는 정수형 데이터 타입
		long long1 = 2_200_000_000L;
		
		// 실수형 데이터 타입 : 실수부를 가지는 데이터 타입
		// float : 4byte(32bit)의 크기를 가지는 실수형 데이터 타입
		// 소수점 아래 6~7자리에서 오차를 발생
		// float float1 = 0.123456789;
		float float2 = 0.123456789f;
		
		// double : 8byte(64bit) 크기를 가지는 실수형 데이터 타입
		// 소수점 15-17자리에서 오차 발생
		double double1 = 0.123456789;
		
		// 문자형 데이터 타입 : 문자 하나를 저장할 수 있는 데이터 타입
		// char : 2byte(16bit)의 크기를 가지는 문자형 데이터 타입
		// 0 ~ 65535
		// 문자를 리터럴로 표현할 때는 '' 사용
		char char1 = 'A';
		char char2 = 65;
		char char3 = '\u0041';
		System.out.println(char1);
		System.out.println(char2);
		System.out.println(char3);
		// 음수를 표현하지 않음. 16bit
		// 첫 bit가 부호를 나타내지 않으므로 같은 bit를 사용해도 양수 방향으로 2배 많은 데이터를 나타낼 수 있음
		
		// 논리형 데이터 타입 : 참과 거짓 값을 가지는 데이터 타입
		// boolean : 1byte(8bit)의 크기를 가지는 논리형 데이터 타입
		boolean boolean1 = true;
		boolean boolean2 = false;
		
		
		// 형변환 실습
		int number1 = 300;
		long number2 = number1;
		number1 = (int)number2;
		
		byte number3 = (byte)number2;
		System.out.println(number3);
		
		double number4 = 3.1415;
		number1 = (int) number4;
		
		number4 = number3;
		System.out.println(number4);
		
		// 배열 : 동일한 타입의 변수를 묶어서 저장하는 컨테이너
		// new 연산자를 이용해서 컨테이너를 먼저 생성해야 함
		// 한 번 생성된 컨테이너의 크기는 변경할 수 없음
		
		// 배열 변수 선언
		// 데이터타입[] 배열명;
		// 배열 생성
		// new 데이터타입[배열의 길이];
		int[] numbers;
		numbers = new int[3];
		System.out.println(numbers);
		
		int[] numbers2 = {1,2,3};
		int[] numbers3 = new int[] {1,2,3};
		// {}는 코드 블럭
		
		System.out.println(numbers2);
		System.out.println(numbers3);
		
		// 배열의 요소에 접근 혹은 사용할 대는 '인덱스' 사용
		// 배열의 시작 인덱스는 0, 종료 인덱스는 길이 - 1
		int number = numbers3[1];
		System.out.println(number);
		
		numbers3[1] = 22;
		System.out.println(numbers3[1]);
		
		// 배열의 길이를 초과하는 인덱스에 접근할 시 예외 발생
		// System.out.println(numbers3[9]);
		// ArrayIndexOutOfBoundsException : 인덱스가 배열 길이보다 클 때 발생하는 에러
		
		// 배열의 길이를 확인하고자 할 땐 .length
		System.out.println(numbers3.length);
		System.out.println(numbers3[numbers3.length-1]);
		
		int lastIndex = numbers3.length-1;
		System.out.println(numbers3[lastIndex]);
		
		// 장점 : 여러 변수를 묶을 수 있음
		// 단점 : 한 번 생성된 컨테이너 크기를 변경할 수 없음
		// 단점이 너무 크므로 잘 사용되지 않음
		
		int[] example1 = new int[] {0,0,0};
		int[] example2 = example1;
		
		System.out.println(example1);
		System.out.println(example2);
		
		example1[2] = 1;
		System.out.println(example2[2]);
		
	      char[] chars = {'e', 'x', 'a', 'm'};
	      System.out.println(chars); // exam, char의 특별 케이스래.
	      
	      // String : 문자의 배열(문자열)을 표현하는데 사용되는 참조형 데이터 타입
	      // 선언
	      // String 변수명;
	      // 생성
	      // new String();
	      // 초기화
	      // 변수명 = "문자열";
	      String string1;
	      string1 = "맑음";
	      String string2 = "오후";
	      
	      // String 객체는 불변성(변경이 불가능)을 가짐
	      String string3 = "exam";
	      System.out.println(chars);
	      System.out.println(string3);
	      chars[0] = 'd';
	      // string3[0] = 'd'; // 하는 역할은 char의 배열 역할이지만 배열이 아니다 그렇기에 원래 있던 값 변화 x
	      string3 = "dxam"; // 이렇게 바꾸는 건 가능
	      System.out.println(string3);
	      
	      // String 클래스의 주요 기능
	      String statement = "  My Name Is Loki  ";
	      
	      // 1. 문자열 결합
	      // + 혹은 concat(문자열)으로 두 문자열을 연결할 수 있음.
	      System.out.println(statement + "@@@@");
	      System.out.println(statement.concat("!!!!"));
	      
	      // 2. 문자열 비교
	      // equals(문자열) : 두 문자열이 동등한지 비교
	      // compareTo(문자열) : 두 문자열을 사전순으로 비교 (대소문자 구분)
	      // compareToIgnoreCase(문자열) : 두 문자열을 사전순으로 비교 (대소문자 구분x)
	      
	      System.out.println(statement.equals("My Name Is Loki"));
	      System.out.println(statement.compareTo("  My Name Is Loki  ")); // 결과값이 사전순으로 먼저 나오면 양수 늦게 나오면 음수
	      
	      // 3. 문자열 길이
	      // length(): 문자열의 길이 반환
	      System.out.println(statement.length());
	      
	      // 4. 문자열 변환
	      // toUpperCase(): 모두 대문자로 변환
	      // toLowerCase(): 모두 소문자로 변환
	      // trim(): 앞뒤 공백 제거
	      // replace(찾을문자열, 바꿀문자열): 특정 문자열을 찾아 변경
	      
	      System.out.println(statement.toUpperCase());
	      System.out.println(statement.toLowerCase());
	      System.out.println(statement.trim());
	      System.out.println(statement.replace("Loki", "Hulk")); // 첫번쨰 로키만 헐크로
	      System.out.println(statement.replaceAll("Loki", "Hulk")); // 모든 로키를 헐크로
	      
	      // 5. 문자열 찾기
	      // indexOf(문자열): 찾고자하는 문자열의 처음 찾은 위치의 인덱스 번호를 반환
	      // lastIndexOF(문자열): 찾고자하는 문자열의 마지막 위치의 인덱스 번호를 반환
	      statement = "내가 그린 기린 그림은 잘 그린 기린 그림이고 네가 그린 기린 그림은 잘 못그린 기린 그림이다.";
	      System.out.println(statement.indexOf("그림"));
	      System.out.println(statement.indexOf("사진")); // 없는건 -1
	      
	      // 6. 부분 문자열
	      // substring(시작인덱스), substring(시작인덱스, 종료인덱스): 문자열을 원하는 크기만큼 추출
	      System.out.println(statement.substring(13));
	      System.out.println(statement.substring(13,23));
	      
	      // 참조형 데이터 타입
	      // 주소를 가지는 변수의 데이터 타입
	      // null을 가질 수 있음(null: 아무것도 지정되지 않은 상태)
	      // 배열, 클래스, 인터페이스, 열거형이 참조형 데이터 타입에 속함
	      String string4 = null;
	      string4.substring(0); // NullPointerException
	      
	   

	

		
		
		
		
		
		
		
	}
}
