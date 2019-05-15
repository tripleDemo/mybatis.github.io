package code.mybatis.hello;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

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
		//1.从classpath路径去加载MyBatis全局配置文件：mybatis-config.xml
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		//2.创建SqlSessionFactory对象，好比是DataSource
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.创建SqlSession对象，好比是Connection
		SqlSession session = factory.openSession();
		//4.具体的操作（增删改查）
		User u = session.selectOne("code.mybatis.hello.UserMapper.get",1L);
		//5.关闭SqlSession
		session.close();
		System.out.println(u);
	}

	//查询所有的用户信息
	@Test
	void testListALL() throws Exception {
		try(SqlSession session = MyBatisUtil.getSession();){				
			//具体的操作（增删改查）
			List<User> us = session.selectList("code.mybatis.hello.UserMapper.listAll");
			for(User u : us) {
				System.out.println(u);
			}
		}
	}

	//修改ID为3的用户信息
	@Test
	void testUpdate() throws Exception {
		User u = new User();
		u.setName("Gogo");
		u.setSalary(new BigDecimal("20000"));
		u.setId(3L);
		SqlSession session = MyBatisUtil.getSession();
		session.update("code.mybatis.hello.UserMapper.update",u);
		session.commit();
		session.close();
	}

	//删除ID为3的用户信息
	@Test
	void testDelete() throws Exception {
		SqlSession session = MyBatisUtil.getSession();
		session.update("code.mybatis.hello.UserMapper.delete",3L);
		session.commit();
		session.close();
	}

	//保存一条用户信息
	@Test
	void testSave() throws Exception {
		User u = new User();
		u.setName("Jenny");
		u.setSalary(new BigDecimal("20000"));
		//System.out.println(u.getId());
		SqlSession session = MyBatisUtil.getSession();
		session.update("code.mybatis.hello.UserMapper.save",u);
		session.commit();
		session.close();
		//System.out.println(u.getId());
	}
}
