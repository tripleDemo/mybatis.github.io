package code.mybatis.hello.mapper;

import code.mybatis.hello.domain.Department;

public interface DepartmentMapper {
	/* void save(Department d); */

	Department get(Long id);
}
