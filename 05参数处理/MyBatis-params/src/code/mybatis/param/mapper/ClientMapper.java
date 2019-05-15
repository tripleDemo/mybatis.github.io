package code.mybatis.param.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import code.mybatis.param.LoginVO;
import code.mybatis.param.domain.Client;

/*���MyBatisֻ�ܽ���һ������������
 * Object selectOne(String statement,Object parameterObject);
 * ��ʽһ������POJO(Java����)�����ԣ�������Ҫ����ܶ��JavaBean���ܷ�
 * ��ʽ������װMap����Map��key�ñ���JavaBean���������ƣ�Map��value�ñ���JavaBean������ֵ,�鷳��ÿ�ζ�Ҫ����Map
 * ��ʽ����ʹ��Paramע�⣬�ײ�ԭ����Ƿ�ʽ����MyBatis������ʹ��Map����װ*/
public interface ClientMapper {
	//��ʽһ���Ѷ��������װ��JavaBean
	Client login1(LoginVO vo);
	//��ʽ����ʹ��Map��������װ�������
	Client login2(Map<String, Object> paramMap);
	//��ʽ����ʹ��Paramע�⣬ԭ���Ƿ�ʽ����Paramע���е��ַ�����ʾ��Map�е�key
	Client login3(@Param("username")String string, @Param("password")String string2);
	
	List<Client> list(@Param("orderBy")String orderBy);
}
