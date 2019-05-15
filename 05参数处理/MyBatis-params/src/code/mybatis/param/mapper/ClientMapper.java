package code.mybatis.param.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import code.mybatis.param.LoginVO;
import code.mybatis.param.domain.Client;

/*解决MyBatis只能接受一个参数的问题
 * Object selectOne(String statement,Object parameterObject);
 * 方式一：封账POJO(Java对象)，可以，但是需要定义很多的JavaBean，很烦
 * 方式二：封装Map对象，Map的key好比是JavaBean的属性名称，Map的value好比是JavaBean的属性值,麻烦，每次都要创建Map
 * 方式三：使用Param注解，底层原理就是方式二，MyBatis帮我们使用Map来封装*/
public interface ClientMapper {
	//方式一：把多个参数封装成JavaBean
	Client login1(LoginVO vo);
	//方式二：使用Map对象来封装多个参数
	Client login2(Map<String, Object> paramMap);
	//方式三：使用Param注解，原理是方式二，Param注解中的字符串表示在Map中的key
	Client login3(@Param("username")String string, @Param("password")String string2);
	
	List<Client> list(@Param("orderBy")String orderBy);
}
