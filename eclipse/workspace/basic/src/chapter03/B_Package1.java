package chapter03;

public class B_Package1 {

   public static void main(String[] args) {
      
      // Wrapper 클래스: 기본형 데이터 타입을 참조형 데이터 타입으로 다룰 수 있도록 도움을 주는 클래스
      // 일반적으로 기본형 데이터 타입의 풀네임에 첫 글자를 대문자로 지정
      
      // int -> Integer
      int basicInt = 10;
      Integer wrapperInteger = null;
      wrapperInteger = basicInt;
      // wrapper 클래스는 null을 가질 수 있기 때문에
      // 기본형 데이터 타입에 참조형 데이터 타입을 할당할 땐 주의 해야함
      basicInt = wrapperInteger;
      System.out.println(basicInt);
      
      // double -> Double
      double basicDouble = 1.0;
      Double wrapperDouble = 1.0;
      
      
      // boolean -> Boolean
      boolean basicBoolean = false;
      Boolean wrapperBoolean = true;
      
      // Wrapper 클래스에서 자주 사용되는 기능
      // parse 메서드: 문자열을 특정 타입으로 변경
      double number = Double.parseDouble("10.11");
      // toString 메서드: 특정 타입을 문자열로 변경
      String string = Double.toString(10.11);
      string = wrapperDouble.toString();      
      
      // Math 클래스 : 수학 연산과 관련된 다양한 메서드 제공
      // 모든 메서드가 static인 클래스 메서드
      
      // ceil() : 올림 메서드
      // floor() : 내림 메서드
      // round() : 반올림 메서드
      System.out.println(Math.ceil(3.14));
      System.out.println(Math.floor(3.14));
      System.out.println(Math.round(3.14));
      
      // 소수점 자리에서 반올림
      // 3.1415 -> 3.14
      System.out.println(Math.round(3.1415 * 100));
      System.out.println(Math.round(3.1415 * 100) / 100.0);
      	
      // 정수 자리에서 반올림
      // 98765 -> 98800
      System.out.println(Math.round(98765 / 100.00));
      System.out.println(Math.round(98765 / 100.00) * 100);
      
   }
}
