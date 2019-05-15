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
		//��ѯIDΪ2������
		mapper.selectByPrimaryKey(key);
		
		//��ѯuserType��10-15֮����û�
		//��װ��ѯ����
		SystemUserExample example = new SystemUserExample();
		Criteria criteria = example.createCriteria();
		//criteria.andUserTypeGreaterThanOrEqualTo(10).andUserTypeLessThanOrEqualTo(15);
		criteria.andUserTypeBetween(10, 15);	
		//��ѯuserType��10-15֮����������û�
		criteria.andUsernameLike("%��%");
		mapper.selectByExample(example);
	}
}
