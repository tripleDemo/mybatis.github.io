package code.mybatis.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.ibatis.session.SqlSession;

//ģ��MyBatis�Ķ�̬ԭ��
public class MyMapperProxy<T> implements InvocationHandler {
	private Class<T> mapperInterface;
	private SqlSession session;
	public void setMapperInterface(Class<T> mapperInterface) {
		this.mapperInterface = mapperInterface;
	}
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	//�����������
	public T getProxyObject() {
		return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] {mapperInterface},this);
	}
	
	//������ô��ǿ
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//Mapper�ӿڵ�ȫ�޶���(�����ռ�)
		String namespaceName = mapperInterface.getName();
		//��������(ִ�в�����id����ֵ)
		String methodName = method.getName();
		String statement = namespaceName+"."+methodName;
		//���ݲ�ͬ��Mapper�������ò�ͬ�ķ���ִ�о������
		return session.selectList(statement);
	}
	
}
