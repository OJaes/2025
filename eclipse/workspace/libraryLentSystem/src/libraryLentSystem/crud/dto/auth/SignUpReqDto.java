package libraryLentSystem.crud.dto.auth;

import java.util.Scanner;

public class SignUpReqDto {
	
	private String id;
	private String pw;
	private String name;
	private String birth;
	private String phoneNumber;
	private String address;
	
	public SignUpReqDto() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ID : ");
		this.id = sc.nextLine();
		System.out.print("PW : ");
		this.pw = sc.nextLine();
		System.out.print("이름 : ");
		this.name = sc.nextLine();
		System.out.print("생년월일 : ");
		this.birth = sc.nextLine();
		System.out.print("전화번호 : ");
		this.phoneNumber = sc.nextLine();
		System.out.print("주소 : ");
		this.address = sc.nextLine();
		validate();
	}
	
	public boolean validate() {
		if(idValidate() && pwValidate() && nameValidate() && birthValidate() && phoneNumberValidate() && addressValidate()) return false;
		return true;
	}
	
	private boolean idValidate() {
		if(id.length() < 6 || id.length() > 12) {
			System.out.println("ID는 6글자 이상 12글자 이하이어야 합니다.");
			return false;
		}
		return true;
	}
	
	private boolean pwValidate() {
		if(pw.length() < 8 || pw.length() > 20) {
			System.out.println("비밀번호는 8글자 이상 20글자 이하이어야 합니다.");
			return false;
		}
		return true;
	}
	
	private boolean nameValidate() {
		if(name.isBlank()) {
			System.out.println("이름을 입력해주세요.");
			return false;
		}
		return true;
	}
	
	private boolean birthValidate() {
		if(birth.isBlank()) {
			System.out.println("생년월일을 입력해주세요.");
			return false;
		}
		if(!(birth.length() == 10)) {
			System.out.println("다음 예시에 맞추어 생년월일을 입력해주세요.");
			System.out.println("YYYY-MM-DD");
			return false;
		}
		return true;
	}
	
	private boolean phoneNumberValidate() {
		if(phoneNumber.isBlank()) {
			System.out.println("휴대폰 번호를 입력해주세요.");
			return false;
		}
		return true;
	}
	
	private boolean addressValidate() {
		if(address.isBlank()) {
			System.out.println("주소를 입력해주세요.");
			return false;
		}
		return true;
		
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getBirth() {
		return birth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}
	
	
}
