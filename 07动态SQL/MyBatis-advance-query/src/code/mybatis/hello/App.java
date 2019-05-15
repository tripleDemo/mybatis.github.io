package code.mybatis.hello;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import code.mybatis.hello.domain.Employee;
import code.mybatis.hello.mapper.EmployeeMapper;
import code.mybatis.hello.query.EmployeeQueryObject;
import code.mybatis.hello.query.PageResult;
import code.mybatis.hello.service.IEmployeeService;
import code.mybatis.hello.service.impl.EmployeeServiceImpl;
import code.mybatis.util.MyBatisUtil;

public class App {
	//需求：按照员工的关键字(abc),工资范围，所属部门来查询
	@Test
	void test1() throws Exception {
		EmployeeQueryObject qo = new EmployeeQueryObject();
		//qo.setKeyword(" ");
		qo.setMinSalary(new BigDecimal("1000"));
		qo.setMaxSalary(new BigDecimal("2000"));
		qo.setDeptId(30L);
		EmployeeMapper employeeMapper = MyBatisUtil.getMapper(EmployeeMapper.class);
		List<Employee> es = employeeMapper.queryForList(qo);
		for(Employee e : es) {
			System.out.println(e);
		}
	}
	
	@Test
	void test2() throws Exception {
		EmployeeQueryObject qo = new EmployeeQueryObject();
		qo.setMinSalary(new BigDecimal("1000"));
		qo.setMaxSalary(new BigDecimal("2000"));
		qo.setDeptId(30L);
		EmployeeMapper employeeMapper = MyBatisUtil.getMapper(EmployeeMapper.class);
		int rows = employeeMapper.queryForCount(qo);
		System.out.println(rows);
	}
	
	@Test
	void testQuery() throws Exception {
		EmployeeQueryObject qo = new EmployeeQueryObject();
		IEmployeeService service = new EmployeeServiceImpl();
		//qo.setMinSalary(new BigDecimal("1000"));
		//qo.setMaxSalary(new BigDecimal("2000"));
		//qo.setDeptId(30L);
		qo.setKeyword("2");
		PageResult pageResult = service.query(qo);
		System.out.println(pageResult.getTotalCount());
		for(Object o : pageResult.getResult()) {
			System.out.println(o);
		}
	}
}
