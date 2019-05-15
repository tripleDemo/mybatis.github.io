package code.mybatis.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory = null;
	
	static {
		try {
			//����SqlSessionFactory����
			factory = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis-config.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//����һ��SqlSession����
	public static SqlSession getSession() {
		return factory.openSession();
	}
	
	public static <T> T getMapper(Class<T> mapperClass){
		return getSession().getMapper(mapperClass);
	}
}
