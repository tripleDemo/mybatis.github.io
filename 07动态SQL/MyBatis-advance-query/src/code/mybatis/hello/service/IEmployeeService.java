package code.mybatis.hello.service;

import code.mybatis.hello.query.EmployeeQueryObject;
import code.mybatis.hello.query.PageResult;
import code.mybatis.hello.query.QueryObject;

public interface IEmployeeService {
	PageResult query(QueryObject qo);
}
