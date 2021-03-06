package cn.hzm.hz.service.test;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

import cn.hzm.hz.entity.User;
import cn.hzm.hz.service.UserService;

import cn.hzm.hz.test.BaseTest;



public class shiroTest extends BaseTest{

	/*@Resource
	private testService ts;*/
	@Resource
	private UserService us;
	//@Test  
	/*public void testHelloworld() {  
	    //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  
	    Factory<org.apache.shiro.mgt.SecurityManager> factory =  
	            new IniSecurityManagerFactory("classpath:config/shiro.ini");  
	    //2、得到SecurityManager实例 并绑定给SecurityUtils  
	    org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();  
	    SecurityUtils.setSecurityManager(securityManager);  
	    //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）  
	    Subject subject = SecurityUtils.getSubject();  
	    UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");  
	  
	    try {  
	        //4、登录，即身份验证  
	        subject.login(token);  
	    } catch (AuthenticationException e) {  
	        //5、身份验证失败  
	    	System.out.println(" 身份验证失败  ");
	    }  
	  
	    Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录  
	  System.out.println(subject.isAuthenticated());
	    //6、退出  
	    subject.logout();  
	}  */
	/*@Test
	public void ssss(){
		System.out.println(ts.testSc());
	}*/
	
	@Test
	public void testUs1(){
		System.out.println(us.findByUsername("hzm1"));
	}
	@Test
	public void testUs2(){
		System.out.println(us.findRoles("hzm1"));
	}
	@Test
	public void tsetUs3(){
		System.out.println(us.findPermissions("hzm3"));
	}
	/*@Test
	public void testUs4(){
		User user = new User();
		user.setUsername("hzm1");
		user.setPassword("123");
		SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));   
	}*/
	
}