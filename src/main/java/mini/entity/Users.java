package mini.entity;

public class Users {
	private int user_id;
	private String username;
	private String password;
	private String email;
	private String phone_number;

	// 기본 생성자
	public Users() {}
	public Users(int user_id, String username, String password, String email, String phone_number) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone_number = phone_number;
		

	}
	//렌탈,스키와 유저 아이디가 동일한지 확인하기 위한 생성자
	public Users(int user_id) {
		this.user_id = user_id;
	}
	
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phone_number=" + phone_number + "]";
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	

}
