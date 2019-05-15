package code.mybatis.hello.mapper;

import java.util.List;

import code.mybatis.hello.domain.User;

/*ʹ��namespace.id�ķ�ʽȥ�ҵ�SQLԪ�أ���ִ��SQL���
 * �÷�ʽ�����ż������⣺
 * 1.��Ϊ�������String���͵Ĳ��������Կ��ܻ�д����һ��д��ֻ�������е�ʱ����ܷ���
 * 2.�����MyBatis��Ҫ�Ĳ��������ǲ������ģ���Ϊ��SqlSession�д��ݵĲ������Ͷ���Object����
 * 3.ÿһ�������Ĵ���ģ����ʵ������ͬ��
 * 
 * ���������ʹ��Mapper�ӿڣ�������DAO�ӿڣ���Mapper�ӿ���ȥ����ÿһ����������
 * 
 * Mapper�����Mapper�ӿ�+Mapper�ļ�
 * 1.Mapper�ļ���Mapper�ӿ�Ӧ�÷���ͬһ������
 * 2.Mapper�ļ��е�namespace������Ϊ��ӦMapper�ӿڵ�ȫ�޶�����
 * 3.Mapper�ļ��еĲ���Ԫ�ص�ID��ӦMapper�ӿ��еķ�������*/
public interface UserMapper {
	
	void save(User u);
	
	void update(User u);
	
	void delete(Long id);
	
	User get(Long id);
	
	List<User> listAll();
}
