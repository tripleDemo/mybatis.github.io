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
	/*@Test
	void testSave() throws Exception {
		Department d = new Department();
		d.setName("开发部");
		Employee e1 = new Employee();
		e1.setName("张三");
		Employee e2 = new Employee();
		e2.setName("李四");
		//维护对象关系
		d.getEmps().add(e1);
		d.getEmps().add(e2);
		
		SqlSession session = MyBatisUtil.getSession();
		DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		//保存操作
		departmentMapper.save(d);
		e1.setDeptId(d.getId());
		e2.setDeptId(d.getId());
		employeeMapper.save(e1);
		employeeMapper.save(e2);
		session.commit();
	}*/

	//查询10号部门的信息和包含的员工信息
	@Test
	void testGet() throws Exception {
		SqlSession session = MyBatisUtil.getSession();
		DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		Department d = departmentMapper.get(10L);
		System.out.println(d);
		//System.out.println(d.getEmps());
	}
}
