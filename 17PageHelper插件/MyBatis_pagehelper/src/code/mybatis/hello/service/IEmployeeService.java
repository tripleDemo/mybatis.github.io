package code.mybatis.hello.service;

import com.github.pagehelper.PageInfo;
import code.mybatis.hello.query.EmployeeQueryObject;
import code.mybatis.hello.query.QueryObject;

public interface IEmployeeService {
	PageInfo<?> query(QueryObject qo);
}
