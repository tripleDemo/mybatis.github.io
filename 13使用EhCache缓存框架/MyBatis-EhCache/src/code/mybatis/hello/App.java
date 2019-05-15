package code.mybatis.hello;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import code.mybatis.hello.domain.Teacher;
import code.mybatis.hello.mapper.TeacherMapper;
import code.mybatis.util.MyBatisUtil;

public class App {
	//һ������:SqlSession����
	@Test
	void testGet() throws Exception {
		//һ������鿴����
		/*TeacherMapper teacherMapper = MyBatisUtil.getMapper(TeacherMapper.class);
		Teacher t1 = teacherMapper.get(1L);
		System.out.println(t1);
		Teacher t2 = teacherMapper.get(1L);
		System.out.println(t2);*/
		SqlSession session = MyBatisUtil.getSession();
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		Teacher t1 = teacherMapper.get(1L);
		System.out.println(t1);
		session.clearCache();//���һ������
		Teacher t2 = teacherMapper.get(1L);
		System.out.println(t2);	
	}

	//һ������:mapper����
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
