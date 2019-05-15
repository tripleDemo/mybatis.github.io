package code.mybatis.hello.service.impl;

import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import code.mybatis.hello.mapper.EmployeeMapper;
import code.mybatis.hello.query.QueryObject;
import code.mybatis.hello.service.IEmployeeService;
import code.mybatis.util.MyBatisUtil;

public class EmployeeServiceImpl implements IEmployeeService {
	
	private EmployeeMapper employeeMapper = MyBatisUtil.getMapper(EmployeeMapper.class);
	
	public PageInfo<?> query(QueryObject qo) {
		PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
		List<?> list = employeeMapper.queryForList(qo);
		return new PageInfo<>(list);
	}

}
