package code.mybatis.hello;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import code.mybatis.hello.domain.User;
import code.mybatis.hello.mapper.UserMapper;
import code.mybatis.util.MyBatisUtil;

public class App {
	
	//��ѯidΪ1���û���Ϣ
	@Test
	void testGet() throws Exception {
		SqlSession session = MyBatisUtil.getSession();
		//��ǰ
		//User u = session.selectOne("code.mybatis.hello.UserMapper.get",1L);
		//Mapper�ӿ�
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User u = userMapper.get(1L);
		session.close();
		session.close();
		System.out.println(u);
	}

	//��ѯ���е��û���Ϣ
	@Test
	void testListALL() throws Exception {
		SqlSession session = MyBatisUtil.getSession();				
		//��ǰ
		//List<User> us = session.selectList("code.mybatis.hello.UserMapper.listAll");
		//Mapper�ӿ�
		UserMapper userMapper = session.getMapper(UserMapper.class);
		//Mapper�ӿ�ԭ����̬����
		//�������com.sun.proxy.$Proxy8
		System.out.println(userMapper.getClass());
		List<User> us = userMapper.listAll();
		session.close();
		for(User u : us) {
			System.out.println(u);
		}
	}

	//�޸�IDΪ5���û���Ϣ
	@Test
	void testUpdate() throws Exception {
		User u = new User();
		u.setName("Gogo");
		u.setSalary(new BigDecimal("20000"));
		u.setId(5L);
		SqlSession session = MyBatisUtil.getSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		userMapper.update(u);
		session.commit();
		session.close();
	}

	//ɾ��IDΪ5���û���Ϣ
	@Test
	void testDelete() throws Exception {
		SqlSession session = MyBatisUtil.getSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		userMapper.delete(5L);
		session.commit();
		session.close();
	}

	//����һ���û���Ϣ
	@Test
	void testSave() throws Exception {
		User u = new User();
		u.setName("Jenny");
		u.setSalary(new BigDecimal("20000"));
		System.out.println(u);
		SqlSession session = MyBatisUtil.getSession();	
		UserMapper userMapper = session.getMapper(UserMapper.class);
		userMapper.save(u);
		session.commit();
		session.close();
		System.out.println(u);
	}

}
