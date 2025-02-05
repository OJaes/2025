package chapter03;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class D_Package3 {
	public static void main(String[] args) {
		
		// Date 클래스 : 날짜를 다루는 클래스
		// Date 클래스의 대부분의 메서드는 Java1.1부터 사용하지 않도록 권장
		// Date 클래스가 날짜의 데이터 타입으로 자주 사용됨(실제 날짜 관리는 문자열이 편함)
		// java.util.Date
		
		Date dateNow = new Date();
		System.out.println(dateNow);
		// deprecated : 더이상 사용되지 않음
		System.out.println(dateNow.getDate());
		
		// LocalDateTime 클래스 : java 8부터 Date 클래스 대체
		// LocalDate 클래스, LocalTime 클래스, LocalDateTime 클래스
		
		// 현재 날짜 및 시간의 인스턴스 생성
		LocalDateTime now = LocalDateTime.now();
		LocalDate nowDate = LocalDate.now();
		LocalTime nowTime = LocalTime.now();
		
		
		// 특정 시간 및 날짜의 인스턴스 생성
		LocalDateTime date1 = LocalDateTime.of(2025, 1, 6, 0, 0, 0);
		System.out.println(date1);
		
		// 특정 날짜 및 시간의 요소 불러오기
		// .getXXX()
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int dayYear = now.getDayOfYear();
		System.out.println(dayYear);
		
		// 틀정 날짜 및 시간의 요소 변경하기
		// withXXX()
		// 인스턴스가 직접 변경되는 것이 아닌 변경된 인스턴스를 생성하여 반환
		System.out.println(now);
		System.out.println(now.withYear(2020));
		
		// 날짜 및 시간 계산하기
		// plusXXX(), minusXXX()
		// 인스턴스가 직접 변경되지 않고 변경된 인스턴스를 생성하여 반환
		now = now.plusHours(18).minusMinutes(20);
		System.out.println(now);
		
		// LocalDateTime을 Date로 변경
		// Date 클래스의 from 메서드와 LocalDateTime 인스턴스의 toInstant 메서드를 활용
		Date localToDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
		System.out.println(localToDate);
		
		// Date를 LocalDateTime으로 변경
		// Date 인스턴스의 toInstant, toLocalDateTime 메서드 사용
		LocalDateTime dateToLocal = dateNow.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println(dateToLocal);
		
		// Date를 문자열 형태로 변환하는 방법
		// SimpleDateFormat 클래스를 이용하여 지정한 문자열 포맷으로 변경
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		String stringDate = simpleDateFormat.format(dateNow);
		System.out.println(stringDate);
		
		// y : 연도, M : 월, d : 일, a : 오전오후, H : 시간(24시), h : 시간(12시), m : 분, s : 초
		simpleDateFormat = new SimpleDateFormat("a h:m y-M-d");
		stringDate = simpleDateFormat.format(dateNow);
		System.out.println(stringDate);
		
		// LocalDateTime을 String으로 변환
		// DateTimeFormatter 클래스를 이용해서 변경 가능
		stringDate = now.format(DateTimeFormatter.ofPattern("a hh:mm yyyy-MM-dd"));
		System.out.println(stringDate);
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("a hh:mm yyyy-MM-dd")));
		
	}
}
