package code.mybatis.hello.mapper;

import java.util.List;

import code.mybatis.hello.domain.Employee;
import code.mybatis.hello.query.EmployeeQueryObject;
import code.mybatis.hello.query.QueryObject;

public interface EmployeeMapper {
	List<Employee> queryForList(QueryObject qo);
	
	int queryForCount(QueryObject qo);
}
