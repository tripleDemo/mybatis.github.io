package code.mybatis.hello.mapper;

import java.util.List;

import code.mybatis.hello.domain.User;

/*使用namespace.id的方式去找到SQL元素，并执行SQL语句
 * 该方式存在着几个问题：
 * 1.因为传入的是String类型的参数，所以可能会写错，而一旦写错只有在运行的时候才能发现
 * 2.传入的MyBatis需要的参数类型是不被检查的，因为在SqlSession中传递的参数类型都是Object类型
 * 3.每一个操作的代码模块其实都是相同的
 * 
 * 解决方案：使用Mapper接口，类似于DAO接口，在Mapper接口中去定义每一个操作方法
 * 
 * Mapper组件：Mapper接口+Mapper文件
 * 1.Mapper文件和Mapper接口应该放在同一个包中
 * 2.Mapper文件中的namespace就设置为对应Mapper接口的全限定名称
 * 3.Mapper文件中的操作元素的ID对应Mapper接口中的方法名称*/
public interface UserMapper {
	
	void save(User u);
	
	void update(User u);
	
	void delete(Long id);
	
	User get(Long id);
	
	List<User> listAll();
}
