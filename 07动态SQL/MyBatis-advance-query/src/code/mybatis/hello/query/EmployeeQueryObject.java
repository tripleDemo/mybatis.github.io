package code.mybatis.hello.query;

import java.math.BigDecimal;

//��װԱ���ĸ߼���ѯ��Ϣ
public class EmployeeQueryObject extends QueryObject {
	private String keyword;//�ؼ��֣�Ա�������ֻ���Ա���ı��
	private BigDecimal minSalary;//��͹���
 	private BigDecimal maxSalary;//��߹���
 	private Long deptId = -1L;//����IDȱʡΪ-1��ʾ���в���
 	
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
