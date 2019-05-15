package code.mybatis.param.domain;

import java.math.BigDecimal;

//@Alias("author")//若有注解，则别名为其注解值。
public class Client {
	private Long id;
	private String username;
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Client [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
}
