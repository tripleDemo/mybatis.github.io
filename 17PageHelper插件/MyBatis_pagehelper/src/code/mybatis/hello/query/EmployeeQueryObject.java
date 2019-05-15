package code.mybatis.hello.query;

import java.math.BigDecimal;

//封装员工的高级查询信息
public class EmployeeQueryObject extends QueryObject {
	private String keyword;//关键字，员工的名字或者员工的编号
	private BigDecimal minSalary;//最低工资
 	private BigDecimal maxSalary;//最高工资
 	private Long deptId = -1L;//部门ID缺省为-1表示所有部门
 	
	public String getKeyword() {
		return empty2null(keyword);
	}	
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public BigDecimal getMinSalary() {
		return minSalary;
	}
	
	public void setMinSalary(BigDecimal minSalary) {
		this.minSalary = minSalary;
	}
	
	public BigDecimal getMaxSalary() {
		return maxSalary;
	}
	
	public void setMaxSalary(BigDecimal maxSalary) {
		this.maxSalary = maxSalary;
	}
	public Long getDeptId() {
		return deptId;
	}
	
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	} 
 	
}
