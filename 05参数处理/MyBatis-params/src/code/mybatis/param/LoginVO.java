package code.mybatis.param;

//封装登录的信息
public class LoginVO {
	private String username;
	private String password;
	public LoginVO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
}
