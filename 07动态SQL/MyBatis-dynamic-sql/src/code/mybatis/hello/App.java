package code.mybatis.hello;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import code.mybatis.hello.domain.Employee;
import code.mybatis.hello.mapper.EmployeeMapper;
import code.mybatis.util.MyBatisUtil;

public class App {
	//需求：查询工资范围1000~2000之间的员工
	@Test
	void test1() throws Exception {
		EmployeeMapper employeeMapper = MyBatisUtil.getMapper(EmployeeMapper.class);
		BigDecimal minSalary = new BigDecimal("1000");
		BigDecimal maxSalary = new BigDecimal("2000");
		List<Employee> es = employeeMapper.query(minSalary,maxSalary,null);
		for(Employee e : es) {
			System.out.println(e);
		}
	}

	//需求：查询指定部门的员工信息
	@Test
	void test2() throws Exception {
		EmployeeMapper employeeMapper = MyBatisUtil.getMapper(EmployeeMapper.class);
		List<Employee> es = employeeMapper.query(null,null,20L);
		for(Employee e : es) {
			System.out.println(e);
		}
	}
	
	//根据id号删除员工信息
	@Test
	void test3() throws Exception {
		//EmployeeMapper employeeMapper = MyBatisUtil.getMapper(EmployeeMapper.class);
		//employeeMapper.batchDelete(Arrays.asList(5L,6L));
		SqlSession session = MyBatisUtil.getSession();
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		employeeMapper.batchDelete(Arrays.asList(5L,6L));
		session.commit();
	}
	
	//插入员工信息
	@Test
	void test4() throws Exception {
		List<Employee> list = new ArrayList<>();
		Employee e1 = new Employee();
		e1.setName("小狗");
		e1.setSn("008");
		e1.setSalary(new BigDecimal("2000.00"));
		list.add(e1);
		Employee e2 = new Employee();
		e2.setName("小猫");
		e2.setSn("009");
		e2.setSalary(new BigDecimal("3000.00"));
		list.add(e2);
		//EmployeeMapper employeeMapper = MyBatisUtil.getMapper(EmployeeMapper.class);
		//employeeMapper.batchSave(list);
		SqlSession session = MyBatisUtil.getSession();
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		employeeMapper.batchSave(list);
		session.commit();
		session.close();
	}
	
	//根据id号查找相应员工信息
	@Test
	void test5() throws Exception {
		EmployeeMapper employeeMapper = MyBatisUtil.getMapper(EmployeeMapper.class);
		List<Employee> list = employeeMapper.batchSelectForId(Arrays.asList(1L,2L));
		for(Employee e : list) {
			System.out.println(e);
		}
	}
}
