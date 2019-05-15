package code.mybatis.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.ibatis.session.SqlSession;

//模拟MyBatis的动态原理
public class MyMapperProxy<T> implements InvocationHandler {
	private Class<T> mapperInterface;
	private SqlSession session;
	public void setMapperInterface(Class<T> mapperInterface) {
		this.mapperInterface = mapperInterface;
	}
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	//创建代理对象
	public T getProxyObject() {
		return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] {mapperInterface},this);
	}
	
	//具体怎么增强
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//Mapper接口的全限定名(命名空间)
		String namespaceName = mapperInterface.getName();
		//方法名称(执行操作的id属性值)
		String methodName = method.getName();
		String statement = namespaceName+"."+methodName;
		//根据不同的Mapper方法调用不同的方法执行具体操作
		return session.selectList(statement);
	}
	
}
