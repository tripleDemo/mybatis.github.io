package code.mybatis.hello;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import code.mybatis.util.MyBatisUtil;

public class App {
	//查询id为1的用户信息
	@Test
	void testGet() throws Exception {
		SqlSession session = MyBatisUtil.getSession();
		//具体的操作（增删改查）
		User u = session.selectOne("code.mybatis.hello.UserMapper.get",1L);
		//关闭SqlSession
		session.close();
		System.out.println(u);
	}

	//查询所有的用户信息
	@Test
	void testListALL() throws Exception {
		SqlSession session = MyBatisUtil.getSession();				
		//具体的操作（增删改查）
		List<User> us = session.selectList("code.mybatis.hello.UserMapper.listAll");
		session.close();
		for(User u : us) {
			System.out.println(u);
		}

	}
}
