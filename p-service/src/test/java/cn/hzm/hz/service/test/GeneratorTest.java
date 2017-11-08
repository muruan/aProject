package cn.hzm.hz.service.test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import cn.hzm.hz.test.BaseTest;

public class GeneratorTest extends BaseTest{
	
	@Test
	public void test() throws SQLException, IOException, InterruptedException, XMLParserException, InvalidConfigurationException{
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		//读取配置文件generatorConfig.xml
		File configFile = new File("src/main/resources/config/generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);

		Configuration config = cp.parseConfiguration(configFile);

		DefaultShellCallback callback = new DefaultShellCallback(overwrite);

		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		for (String s : warnings) {
		System.out.println(s);
		}
	
	}

}
