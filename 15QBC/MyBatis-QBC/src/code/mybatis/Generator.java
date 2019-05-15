package code.mybatis;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Generator {
	public static void main(String[] args) throws Exception {
		//MBGִ�й����еľ�����Ϣ
		List<String> warnings = new ArrayList<>();
		//���ɴ����ظ�ʱ���Ƿ񸲸�Դ����
		boolean override = false;
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(in);
		DefaultShellCallback callback = new DefaultShellCallback(override);
		//����MBG
		MyBatisGenerator mbg = new MyBatisGenerator(config, callback, warnings);
		mbg.generate(null);
		//���������Ϣ
		for(String warn : warnings) {
			System.out.println(warn);
		}
	}
}
