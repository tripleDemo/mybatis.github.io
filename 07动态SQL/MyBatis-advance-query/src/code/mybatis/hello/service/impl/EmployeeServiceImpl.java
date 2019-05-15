package code.mybatis.hello.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import code.mybatis.hello.domain.Employee;
import code.mybatis.hello.mapper.EmployeeMapper;
import code.mybatis.hello.query.EmployeeQueryObject;
import code.mybatis.hello.query.PageResult;
import code.mybatis.hello.query.QueryObject;
import code.mybatis.hello.service.IEmployeeService;
import code.mybatis.util.MyBatisUtil;

public class EmployeeServiceImpl implements IEmployeeService {
	
	private EmployeeMapper employeeMapper = MyBatisUtil.getMapper(EmployeeMapper.class);
	public PageResult query(QueryObject qo) {
		int rows = employeeMapper.queryForCount(qo);
		if(rows == 0) {
			return new PageResult(Collections.EMPTY_LIST, 0, 1, qo.getPageSize());
		}
		List<Employee> result = employeeMapper.queryForList(qo);
		return new PageResult(result, rows, qo.getCurrentPage(), qo.getPageSize());
	}

}
