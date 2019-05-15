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
	//����һ�����ź�����Ա��
	/*@Test
	void testSave() throws Exception {
		Department d = new Department();
		d.setName("������");
		Employee e1 = new Employee();
		e1.setName("����");
		Employee e2 = new Employee();
		e2.setName("����");
		//ά�������ϵ
		d.getEmps().add(e1);
		d.getEmps().add(e2);
		
		SqlSession session = MyBatisUtil.getSession();
		DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		//�������
		departmentMapper.save(d);
		e1.setDeptId(d.getId());
		e2.setDeptId(d.getId());
		employeeMapper.save(e1);
		employeeMapper.save(e2);
		session.commit();
	}*/

	//��ѯ10�Ų��ŵ���Ϣ�Ͱ�����Ա����Ϣ
	@Test
	void testGet() throws Exception {
		SqlSession session = MyBatisUtil.getSession();
		DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		Department d = departmentMapper.get(10L);
		System.out.println(d);
		//System.out.println(d.getEmps());
	}
}
