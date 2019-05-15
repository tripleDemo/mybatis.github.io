package code.mybatis.hello.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import code.mybatis.hello.domain.Employee;

public interface EmployeeMapper {

	List<Employee> query(
			@Param("minSalary")BigDecimal minSalary,
			@Param("maxSalary")BigDecimal maxSalary,
			@Param("deptId")Long deptId);

	void batchDelete(@Param("ids")List<Long> ids);

	void batchSave(@Param("emps")List<Employee> emps);

	List<Employee> batchSelectForId(@Param("ids")List<Long> ids);
}
