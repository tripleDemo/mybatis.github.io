package code.mybatis.hello;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import code.mybatis.hello.domain.Department;
import code.mybatis.hello.domain.Employee;
import code.mybatis.hello.mapper.DepartmentMapper;
import code.mybatis.hello.mapper.EmployeeMapper;
import code.mybatis.util.MyBatisUtil;

public class App {
	//保存一个部门和两个员工
	@Test
	void testSave() throws Exception {
		Department d = new Department();
		d.setName("开发部");
		Employee e1 = new Employee();
		e1.setName("张三");
		Employee e2 = new Employee();
		e2.setName("李四");
		//维护对象关系
		e1.setDept(d);
		e2.setDept(d);
		SqlSession session = MyBatisUtil.getSession();
		DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		//保存操作
		departmentMapper.save(d);
		employeeMapper.save(e1);
		employeeMapper.save(e2);
		session.commit();
	}

	@Test
	void testGet() throws Exception {
		SqlSession session = MyBatisUtil.getSession();
		DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		Employee e = employeeMapper.get(1L);
		//现在已经拥有员工所在部门id,但是期望得到的是Department对象
		//解决方案：根据部门的id,再额外的发送一条SQL语句，查询出部门对象，把部门对象设置员工
		/*
		 * 	让MyBatis帮我们去发送这条额外的SQL
			Long deptId = e.getDept().getId();
			Department d = departmentMapper.get(deptId);
			e.setDept(d);
		*/
		System.out.println(e.getDept());
	}
	
	@Test
	void testListAll() throws Exception {
		SqlSession session = MyBatisUtil.getSession();
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		List<Employee> es = employeeMapper.listAll();
		for(Employee e : es) {	
			System.out.println(e);
		}
	}
}
