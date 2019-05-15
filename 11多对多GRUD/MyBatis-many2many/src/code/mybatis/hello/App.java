package code.mybatis.hello;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import code.mybatis.hello.domain.Student;
import code.mybatis.hello.domain.Teacher;
import code.mybatis.hello.mapper.StudentMapper;
import code.mybatis.hello.mapper.TeacherMapper;
import code.mybatis.util.MyBatisUtil;

public class App {
	@Test
	void testSave() throws Exception {
		Teacher t1 = new Teacher();
		t1.setName("老师1");
		Teacher t2 = new Teacher();
		t2.setName("老师2");
		Student s1 = new Student();
		s1.setName("学生1");
		Student s2 = new Student();
		s2.setName("学生2");
		//维护对象之间关系
		s1.getTeachers().add(t1);
		s1.getTeachers().add(t2);
		s2.getTeachers().add(t1);
		s2.getTeachers().add(t2);
		
		SqlSession session = MyBatisUtil.getSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		studentMapper.save(s1);
		studentMapper.save(s2);
		teacherMapper.save(t1);
		teacherMapper.save(t2);
		//s1学生来维护和老师的关系
		for(Teacher t : s1.getTeachers()) {
			studentMapper.insertRelationWithTeacher(s1.getId(), t.getId());
		}
		//s2学生来维护和老师的关系
		for(Teacher t : s2.getTeachers()) {
			studentMapper.insertRelationWithTeacher(s2.getId(), t.getId());
		}
		
		session.commit();
		session.close();
	}
	
	@Test
	void testDelete() throws Exception {
		SqlSession session = MyBatisUtil.getSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		//删除中间数据
		studentMapper.deleteRelationWithTeacher(1L);
		studentMapper.delete(1L);
		session.commit();
		session.close();
	}
	
	@Test
	void testGet() throws Exception {
		SqlSession session = MyBatisUtil.getSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student s = studentMapper.get(1L);
		session.close();
		System.out.println(s);
		//System.out.println(s.getTeachers());
	}
}
