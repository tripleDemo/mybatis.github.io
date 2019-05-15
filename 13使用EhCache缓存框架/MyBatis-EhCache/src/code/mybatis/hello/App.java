package code.mybatis.hello;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import code.mybatis.hello.domain.Teacher;
import code.mybatis.hello.mapper.TeacherMapper;
import code.mybatis.util.MyBatisUtil;

public class App {
	//一级缓存:SqlSession级别
	@Test
	void testGet() throws Exception {
		//一级缓存查看例子
		/*TeacherMapper teacherMapper = MyBatisUtil.getMapper(TeacherMapper.class);
		Teacher t1 = teacherMapper.get(1L);
		System.out.println(t1);
		Teacher t2 = teacherMapper.get(1L);
		System.out.println(t2);*/
		SqlSession session = MyBatisUtil.getSession();
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		Teacher t1 = teacherMapper.get(1L);
		System.out.println(t1);
		session.clearCache();//清空一级缓存
		Teacher t2 = teacherMapper.get(1L);
		System.out.println(t2);	
	}

	//一级缓存:mapper级别
	@Test
	void testSecondLevelCache() throws Exception {
		SqlSession session = MyBatisUtil.getSession();
		TeacherMapper mapper = session.getMapper(TeacherMapper.class);
		mapper.get(1L);
		session.close();
		System.out.println("----------------------------");
		Thread.sleep(3000);
		session = MyBatisUtil.getSession();
		mapper = session.getMapper(TeacherMapper.class);
		mapper.get(1L);
	}
}
