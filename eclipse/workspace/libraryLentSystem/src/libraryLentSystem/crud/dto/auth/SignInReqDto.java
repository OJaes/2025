package libraryLentSystem.crud.dto.auth;

import java.util.Scanner;

public class SignInReqDto {
	private String id;
	private String pw;
	
	public SignInReqDto() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ID : ");
		id = sc.nextLine();
		System.out.print("PW : ");
		pw = sc.nextLine();
		validate();
	}
	
	private boolean validate() {
		if(id.isBlank() || pw.isBlank()) {
			System.out.println("빈 칸을 입력해주세요.");
			return false;
		}return true;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}
	
	
}
