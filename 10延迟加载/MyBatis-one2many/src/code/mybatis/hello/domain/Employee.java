package code.mybatis.hello.domain;

public class Employee {
	private Long id;
	private String name;
	private Long deptId;//员工所在部门的ID
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
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", deptId=" + deptId + "]";
	}
}
