package chapter02;


// 캡슐화 : 인스턴스 필드와 메서드를 하나로 묶어서 필드에 대한 조작을 메서드를 통해서만 하도록 하는 것(getter, setter, 생성자)
// 정보 은닉과 데이터 보호, 데이터 무결성을 보장할 수 있음

// Entity : 데이터베이스의 레코드를 관리하는 객체
// (생성자와 Getter만 유지를 권장)

// DTO (Data Transform Object) : 데이터 전송을 위한 객체
// (불변성 : 생성자와 Getter만 유지)
// (가변성 : 생성자와 Getter, Setter)

// VO (Value Object) : 값을 표현하는 객체
// 가변성을 인정하지 않아 생성자와 Getter만 인정
// Object 클래스의 equals() 메서드를 오버라이딩해서 사용 - (equals를 값 비교로 오버라이딩)


class Player{
	
	Player(String name, String team, String birth, int number) {
		this.name = name;
		this.team = team;
		this.birth = birth;
		this.number = number < 0 ? 0 : number;
	}
	private String name;
	private String team;
	private String birth;
	private int number;
	
	// getter 메서드 : 캡슐화에서 private 필드의 값을 반환하는 메서드
	// setter 메서드 : 캡슐화에서 private 필드의 값을 수정하는 메서드
	
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	String getTeam() {
		return team;
	}
	void setTeam(String team) {
		this.team = team;
	}
	String getBirth() {
		return birth;
	}
	void setBirth(String birth) {
		this.birth = birth;
	}
	int getNumber() {
		return number;
	}
	void setNumber(int number) {
		this.number = number < 0 ? 0 : number;
	}
}

class King {
	private String ho;
	private String name;
	
	public King(String ho, String name) {
		super();
		this.ho = ho;
		this.name = name;
	}

	String getHo() {
		return ho;
	}
	String getName() {
		return name;
	}
	void setHo(String ho) {
		this.ho = ho;
	}
	void setName(String name) {
		this.name = name;
	}
}

public class E_Encapsulation {
	public static void main(String[] args) {
		
//		Player player1 = new Player();
		
//		player1.name = "이성계";
//		player1.team = "조선";
//		player1.birth = "1335-11-04";
//		player1.number = 1;
		
		Player player1 = new Player("이성계", "조선", "1335-11-04", 1);
		player1.setTeam("고려");
		player1.setNumber(-5);
		System.out.println(player1.getTeam());
		System.out.println(player1.getNumber());
	}
}


