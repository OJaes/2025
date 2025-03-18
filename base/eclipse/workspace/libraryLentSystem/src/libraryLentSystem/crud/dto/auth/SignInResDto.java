package libraryLentSystem.crud.dto.auth;

public class SignInResDto {

	private String id;
	private String pw;
	
	public SignInResDto(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}
	
	
	
}
