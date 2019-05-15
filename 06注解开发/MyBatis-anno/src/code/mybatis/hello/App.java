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
	
	//查询id为1的用户信息
	@Test
	void testGet() throws Exception {
		SqlSession session = MyBatisUtil.getSession();
		//以前
		//User u = session.selectOne("code.mybatis.hello.UserMapper.get",1L);
		//Mapper接口
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User u = userMapper.get(1L);
		session.close();
		session.close();
		System.out.println(u);
	}

	//查询所有的用户信息
	@Test
	void testListALL() throws Exception {
		SqlSession session = MyBatisUtil.getSession();				
		//以前
		//List<User> us = session.selectList("code.mybatis.hello.UserMapper.listAll");
		//Mapper接口
		UserMapper userMapper = session.getMapper(UserMapper.class);
		//Mapper接口原理：动态代理
		//代理对象：com.sun.proxy.$Proxy8
		System.out.println(userMapper.getClass());
		List<User> us = userMapper.listAll();
		session.close();
		for(User u : us) {
			System.out.println(u);
		}
	}

	//修改ID为5的用户信息
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

	//删除ID为5的用户信息
	@Test
	void testDelete() throws Exception {
		SqlSession session = MyBatisUtil.getSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		userMapper.delete(5L);
		session.commit();
		session.close();
	}

	//保存一条用户信息
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
