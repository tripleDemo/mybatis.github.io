package code.mybatis.param;

//��װ��¼����Ϣ
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
