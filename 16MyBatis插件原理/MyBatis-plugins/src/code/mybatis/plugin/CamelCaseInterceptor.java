package code.mybatis.plugin;

import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;


//����עҪ����һ������е���һ��������������ǿ
//��ResultSetHandler����е�handleResultSets(Statement st)��������ǿ
@Intercepts(@Signature(//
		type = ResultSetHandler.class, //
		method = "handleResultSets", //
		args = { Statement.class } //
))
public class CamelCaseInterceptor implements Interceptor {
	private Properties properties;
	//��װ
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	//���������������ò��������ÿ�����ʹ������������������
	public void setProperties(Properties properties) {
		this.properties = properties;
		System.out.println(this.properties);
	}

	//�������ǿ��ϸ��
	public Object intercept(Invocation invocation) throws Throwable {
		/* ��һ�����ݷ�װ��Map֮��{u_name=С��, u_id=3, u_sn=003}
		 * �ڶ����л���ϰ��ʹ���շ��ʾ������ϲ��ʹ���»��߷��ı�̣�����Map�е�key���»���ȥ����ʹ���շ��ʾ��
		 * {uName=С��, uId=3, uSn=003}
		 */
		List<Object> list = (List<Object>) invocation.proceed();//����
		for(Object obj : list) {
			if(!(obj instanceof Map)) {
				break;
			}
			//���ÿһ�����ݵķ�װ������Map��ʵ��
			handleMap((Map<String,Object>) obj);
		}
		return list;
	}

	private void handleMap(Map<String,Object> map) {
		Set<String> keySet = new HashSet(map.keySet());
		for(String key : keySet) {
			//�ж�key�Ƿ��Ǵ�д��ĸ��ͷ���ߴ����»���
			if(key.contains("_")) {
				Object value = map.get(key);
				map.remove(key);
				String newKey = handleKey(key);
				map.put(newKey, value);
			}
		}
	}

	private String handleKey(String key) {
		StringBuilder sb = new StringBuilder(10);
		boolean findUnderLine = false;//�Ƿ��ҵ��»���
		for(int index = 0; index < key.length(); index++) {
			char ch = key.charAt(index);//ÿһ����ĸ
			if(ch == '_') {
				findUnderLine = true;//�ҵ�
			}else {
				if(findUnderLine) {
					sb.append(Character.toUpperCase(ch));
					findUnderLine = false;
				}else {
					sb.append(Character.toLowerCase(ch));
				}
			}
		}
		return sb.toString();
	}
}
