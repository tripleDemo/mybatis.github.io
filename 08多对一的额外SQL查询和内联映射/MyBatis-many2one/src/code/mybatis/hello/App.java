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
	@Test
	void testSave() throws Exception {
		Department d = new Department();
		d.setName("������");
		Employee e1 = new Employee();
		e1.setName("����");
		Employee e2 = new Employee();
		e2.setName("����");
		//ά�������ϵ
		e1.setDept(d);
		e2.setDept(d);
		SqlSession session = MyBatisUtil.getSession();
		DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		//�������
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
		//�����Ѿ�ӵ��Ա�����ڲ���id,���������õ�����Department����
		//������������ݲ��ŵ�id,�ٶ���ķ���һ��SQL��䣬��ѯ�����Ŷ��󣬰Ѳ��Ŷ�������Ա��
		/*
		 * 	��MyBatis������ȥ�������������SQL
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
