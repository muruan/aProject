package cn.hzm.hz.test;

import org.junit.Test;
import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring-mybatis.xml","classpath:config/spring-context.xml" })
public class BaseTest {
	@Test
	public void  tssss(){
		System.out.println("测试");
	}
}