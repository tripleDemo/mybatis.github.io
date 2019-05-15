package code.mybatis.hello;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import code.mybatis.hello.domain.Employee;
import code.mybatis.hello.mapper.EmployeeMapper;
import code.mybatis.hello.query.EmployeeQueryObject;
import code.mybatis.hello.service.IEmployeeService;
import code.mybatis.hello.service.impl.EmployeeServiceImpl;
import code.mybatis.util.MyBatisUtil;

public class App {
	@Test
	void testPageHelper() throws Exception {
		EmployeeMapper employeeMapper = MyBatisUtil.getMapper(EmployeeMapper.class);
		//---------------------------------
		//设置分页PageHelper.startPage(当前页码,每页多少条);
		PageHelper.startPage(1,3);
		//---------------------------------
		List<Employee> list = employeeMapper.listAll();
		for(Employee e : list) {
			System.out.println(e);
		}
		
		/*Page page = (Page) list;
		System.out.println("结果总数"+page.getTotal());
		System.out.println("结果集"+page.get(0));*/
		/*Page类：其实就是ArrayList的子类，封装了分页相关的信息，好比就是我们的PageResult类。
		 * 		  但是很不好用，自身既要表示结果集，又要表示分页结果对象*/
		
		PageInfo pageInfo = new PageInfo<>(list);
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getList());
		System.out.println(pageInfo.getPageNum()+"/"+pageInfo.getPages());
		System.out.println(pageInfo.getPrePage());
		System.out.println(pageInfo.getNextPage());
	}
	
	@Test
	void testQuery() throws Exception {
		EmployeeQueryObject qo = new EmployeeQueryObject();
		qo.setCurrentPage(1);
		qo.setPageSize(3);
		IEmployeeService service = new EmployeeServiceImpl();
		qo.setMinSalary(new BigDecimal("1000"));
		//qo.setMaxSalary(new BigDecimal("2000"));
		//qo.setDeptId(30L);
		//qo.setKeyword("2");
		PageInfo pageInfo = service.query(qo);
		System.out.println(pageInfo.getTotal());
		for(Object o : pageInfo.getList()) {
			System.out.println(o);
		}
	}
}
