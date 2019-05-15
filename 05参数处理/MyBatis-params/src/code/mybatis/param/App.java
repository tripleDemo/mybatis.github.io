package code.mybatis.param;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import code.mybatis.param.domain.Client;
import code.mybatis.param.mapper.ClientMapper;
import code.mybatis.util.MyBatisUtil;

public class App {
	@Test
	void testLogin1() throws Exception {
		LoginVO vo = new LoginVO("tom", "1111");
		SqlSession session = MyBatisUtil.getSession();
		ClientMapper clientMapper = session.getMapper(ClientMapper.class);
		Client client = clientMapper.login1(vo);
		session.close();
		System.out.println(client);
	}

	@Test
	void testLogin2() throws Exception {
		Map<String,Object> paramMap = new HashMap<String,Object>() {
			{
				this.put("username","tom");
				this.put("password","1111");
			}
		};
		SqlSession session = MyBatisUtil.getSession();
		ClientMapper clientMapper = session.getMapper(ClientMapper.class);
		Client client = clientMapper.login2(paramMap);
		session.close();
		System.out.println(client);
	}

	@Test
	void testLogin3() throws Exception {
		SqlSession session = MyBatisUtil.getSession();
		ClientMapper clientMapper = session.getMapper(ClientMapper.class);
		Client client = clientMapper.login3("tom","1111");
		session.close();
		System.out.println(client);
	}
	
	@Test
	void test4() throws Exception {
		SqlSession session = MyBatisUtil.getSession();
		ClientMapper clientMapper = session.getMapper(ClientMapper.class);
		List<Client> list = clientMapper.list("id desc");
		session.close();
		for(Client c : list) {
			System.out.println(c);
		}
	}
}
