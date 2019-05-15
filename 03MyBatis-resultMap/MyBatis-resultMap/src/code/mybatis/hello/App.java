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
	//��ѯidΪ1���û���Ϣ
	@Test
	void testGet() throws Exception {
		SqlSession session = MyBatisUtil.getSession();
		//����Ĳ�������ɾ�Ĳ飩
		User u = session.selectOne("code.mybatis.hello.UserMapper.get",1L);
		//�ر�SqlSession
		session.close();
		System.out.println(u);
	}

	//��ѯ���е��û���Ϣ
	@Test
	void testListALL() throws Exception {
		SqlSession session = MyBatisUtil.getSession();				
		//����Ĳ�������ɾ�Ĳ飩
		List<User> us = session.selectList("code.mybatis.hello.UserMapper.listAll");
		session.close();
		for(User u : us) {
			System.out.println(u);
		}

	}
}
