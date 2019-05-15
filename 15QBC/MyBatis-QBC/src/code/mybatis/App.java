package code.mybatis;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import code.mybatis.demo.domain.SystemUserExample;
import code.mybatis.demo.domain.SystemUserExample.Criteria;
import code.mybatis.demo.domain.SystemUserKey;
import code.mybatis.demo.mapper.SystemUserMapper;
import code.mybatis.util.MyBatisUtil;

public class App {
	@Test
	void test1() throws Exception {
		SystemUserMapper mapper = MyBatisUtil.getMapper(SystemUserMapper.class);
		SystemUserKey key = new SystemUserKey();
		key.setId(2L);
		//查询ID为2的数据
		mapper.selectByPrimaryKey(key);
		
		//查询userType在10-15之间的用户
		//封装查询条件
		SystemUserExample example = new SystemUserExample();
		Criteria criteria = example.createCriteria();
		//criteria.andUserTypeGreaterThanOrEqualTo(10).andUserTypeLessThanOrEqualTo(15);
		criteria.andUserTypeBetween(10, 15);	
		//查询userType在10-15之间且姓李的用户
		criteria.andUsernameLike("%李%");
		mapper.selectByExample(example);
	}
}
