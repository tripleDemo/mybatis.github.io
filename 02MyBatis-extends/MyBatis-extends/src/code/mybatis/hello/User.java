package code.mybatis.hello;

import java.math.BigDecimal;

//@Alias("author")//若有注解，则别名为其注解值。
public class User {
	private Long id;
	private String name;
	private BigDecimal salary;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}
