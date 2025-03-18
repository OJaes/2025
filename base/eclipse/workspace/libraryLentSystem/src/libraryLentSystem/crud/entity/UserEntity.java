package libraryLentSystem.crud.entity;

import libraryLentSystem.crud.dto.auth.SignUpReqDto;

public class UserEntity {
	private String id;
	private String pw;
	private String name;
	private String birth;
	private String phoneNumber;
	private String address;
	
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
	public UserEntity(SignUpReqDto dto) {
		this.id = dto.getId();
		this.pw = dto.getPw();
		this.name = dto.getName();
		this.birth = dto.getBirth();
		this.phoneNumber = dto.getPhoneNumber();
		this.address = dto.getAddress();
	}
	
}
