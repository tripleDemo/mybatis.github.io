package code.mybatis.demo.mapper;

import java.util.List;
import java.util.Map;

public interface UserMapper {
	
	//������һ���������кܶ��ֶ�
	//������һ�����󣬰Ѷ����в������ݲ�ѯ������ת����JSON��ʽ���ַ���
    List<Map<String,Object>> listMap();
}