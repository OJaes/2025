package chapter01;

import java.lang.reflect.Array;
import java.util.Arrays;

public class D_Operator {
	public static void main(String[] args) {
		
		int a = 15, b= 2;
		double c = 15.0, d = 7.0;
		
		int intResult = 0;
		double doubleResult = 0;
		
		// 산술 연산자 : 사칙연산을 수행하는 연산자
		
		// 더하기 : +
		// 좌항에 우항을 더한 값을 반환
		intResult = a + b;
		System.out.println(intResult);
		
		doubleResult = c + d;
		System.out.println(doubleResult);
		
		// intResult = a + c;
		doubleResult = a + c;
		System.out.println(doubleResult);
		
		// 빼기 : -
		// 좌항에 우항을 뺀 값을 반환
		
		intResult = a - b;
		System.out.println(intResult);
		doubleResult = a - c;
		System.out.println(doubleResult);
		
		// 곱하기 : *
		// 좌항에 우항을 곱한 값을 반환
		
		intResult = a * b;
		System.out.println(intResult);
		doubleResult = a * c;
		System.out.println(doubleResult);
		
		// 나누기 : /
		// 좌항에 우항을 나눈 값을 반환
		// 정수와 정수를 나누면 실수부가 소멸함(몫만 반환함)
		// 정수끼리 나눈 후에 double 형변환을 해도 몫만 반환함
		doubleResult = a / (double)b;
		System.out.println(doubleResult);
		doubleResult = a / d;
		System.out.println(doubleResult);
		
		// 나머지 연산자 : %
		// 좌항에 우항을 나눈 후 나머지만 반환
		intResult = a % b;
		System.out.println(intResult);
		doubleResult = a % d;
		System.out.println(doubleResult);
		
		// 증감연산자
		// 피연산자 값을 1 증가 혹은 감소
		// 단항 연산자, 피연산자는 반드시 변수이어야 한다.(상수 불가능)
		// 증가 연산자 : ++
		// 감소 연산자 : --
		int number = 7;
		System.out.println(number);
		number++;
		System.out.println(number);
		number--;
		System.out.println(number);
		++number;
		System.out.println(number);
		//number = 8
		// ++number은 값을 먼저 증가시키고 계산
		System.out.println(10 + ++number);
		// number-- 값을 계산하고 number을 감소시킴
		System.out.println(10 - number--);
		// 선행 증감 연산은 증감 연산을 먼저 수행하고 다른 연산을 진행
		// 후행 증감 연산은 다른 연산을 먼저 수행하고 증감 연산을 진행
		
		final int NUMBER = 7;
		// NUMBER--; 상수는 증감이 불가능하다
		// 7++; 리터럴 상수 또한 증감 불가능
		
		// 대입 연산자 : 좌항을 우항에 할당
		
		// 일반 대입 연산자 : =
		// 좌항에 우항의 연산 결과를 할당
		// 좌항에 일반 변수와 상수형 변수 모두 올 수 있음
		// 단, 상수형 변수에는 초기화 시에만 사용 가능
		number = 10 + 5;
		
		// 복합 대입 연산자 : 특정 연산을 수행한 결과를 좌항에 다시 할당
		// 타연산자= 으로, +=, -=, *=, /=, %= 등이 존재함
		// 좌항에 우항의 연산 결과를 좌항에 할당
		// 좌항은 반드시 초기화가 이루어진 일반 변수여야 함
		number += 3;
		System.out.println(number);
		
		number %= 5;
		System.out.println(number);
		
		// int number2;
		// number2 += 1;
		final int NUMBER2 = 10;
		// NUMBER2 += 1;
		
		// 비교 연산자 : 좌항과 우항을 비교해 그 결과를 논리 값으로 반환
		boolean booleanResult = true;
		
		// 같다, 다르다 연산자
		// == : 좌항이 우항과 같으면 true, 다르면 false
		// != : 좌항이 우항과 다르면 true, 같으면 false
		// a : 15, b : 2, c : 15.0, d : 7.0
		booleanResult = a == b;
		System.out.println(booleanResult);
		booleanResult = a != b;
		System.out.println(booleanResult);
		booleanResult = a == c; // 항 중에 실수가 있으면 정수를 실수로 변환하여 비교함
		System.out.println(booleanResult);
		
		// 작다, 작거나 같다 연산자
		// < : 좌항이 우항보다 작으면 true, 크거나 같으면 false
		// <= : 좌항이 우항보다 작거나 같으면 true, 크면 false
		booleanResult = a < c;
		System.out.println(booleanResult);
		booleanResult = a <= c;
		System.out.println(booleanResult);
		
		// 크다, 크거나 같다 연산자
		// > : 좌항이 우항보다 크면 true, 작으면 false
		// >= : 좌항이 우항보다 크거나 같으면 true, 작으면 false
		booleanResult = a > c;
		System.out.println(booleanResult);
		booleanResult = a >= c;
		System.out.println(booleanResult);
		
		/* 12.30 */
		// 논리 연산자 : 피연산자가 모두 논리값인 연산자, 피연산자를 조합
		// 논리 AND 연산자 : && - 좌항과 우항이 모두 true일 때 true를 반환, 하나라도 false이면 false를 반환
		booleanResult = false && true;
		System.out.println(booleanResult);

		booleanResult = (a == b) && (c == d);
		System.out.println(booleanResult);
		
		// 논리 OR 연산자 : || - 좌항이나 우항 중 하나라도 true면 true를 반환, 모두 false이면 false를 반환
		booleanResult = true || false;
		System.out.println(booleanResult);
		
		booleanResult = (a > b) || (c < d);
		System.out.println(booleanResult);
		
		// 논리 NOT 연산자 : ! - 피연산자가 true이면 false, false이면 true 반환
		System.out.println(booleanResult);
		System.out.println(!booleanResult);
		
		// 노란 줄에 deadcode = 컴퓨터가 좌에서 우로 읽는데, 이미 값이 확정될 경우 뒤의 코드는 deadcode, 즉 읽지 않는다.
		// 리터럴(true, false)을 직접적으로 적었기 때문에 할당되는 deadcode이며, 표현식으로 지정될 경우에는 괜찮음
		System.out.println(a);
		booleanResult = false && (a++ > b);
		System.out.println(a);
		// 이처럼 deadcode는 컴퓨터에서 수행을 하지 않기 때문에 a++ 연산이 되지 않음.
		// AND 연산의 경우 좌항이 false이면 우항의 코드는 deadcode가 됨
		// OR 연산의 경우 좌항이 true이면 우항의 코드는 deadcode가 됨
		// 이를 이용해서 true인 경우에만 뒤의 코드를 실행하도록 만들 수 있음.		
		System.out.println(a);
		booleanResult = true || (a++ > b);
		
		// 삼항 연산자 : 조건에 따라 지정한 결과를 반환하는 연산자
		// 조건(논리식) ? 참일 때 결과 : 거짓일 때 결과
		String resultString = true ? "참" : "거짓";
		System.out.println(resultString);
		
		
	}
}
