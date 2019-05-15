package code.mybatis.hello.mapper;

import java.util.List;

import code.mybatis.hello.domain.Employee;

public interface EmployeeMapper {
	void save(Employee d);

	Employee get(long id);

	List<Employee> listAll();
}
