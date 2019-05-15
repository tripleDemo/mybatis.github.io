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
	//��ѯidΪ1���û���Ϣ
	@Test
	void testGet() throws Exception {
		//1.��classpath·��ȥ����MyBatisȫ�������ļ���mybatis-config.xml
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		//2.����SqlSessionFactory���󣬺ñ���DataSource
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.����SqlSession���󣬺ñ���Connection
		SqlSession session = factory.openSession();
		//4.����Ĳ�������ɾ�Ĳ飩
		User u = session.selectOne("code.mybatis.hello.UserMapper.get",1L);
		//5.�ر�SqlSession
		session.close();
		System.out.println(u);
	}

	//��ѯ���е��û���Ϣ
	@Test
	void testListALL() throws Exception {
		try(SqlSession session = MyBatisUtil.getSession();){				
			//����Ĳ�������ɾ�Ĳ飩
			List<User> us = session.selectList("code.mybatis.hello.UserMapper.listAll");
			for(User u : us) {
				System.out.println(u);
			}
		}
	}

	//�޸�IDΪ3���û���Ϣ
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

	//ɾ��IDΪ3���û���Ϣ
	@Test
	void testDelete() throws Exception {
		SqlSession session = MyBatisUtil.getSession();
		session.update("code.mybatis.hello.UserMapper.delete",3L);
		session.commit();
		session.close();
	}

	//����һ���û���Ϣ
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
