package cn.hzm.hz.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.hzm.hz.entity.User;
import cn.hzm.hz.service.UserService;

public class UserRealm extends AuthorizingRealm{

	@Resource
	private UserService userService;

	//权限验证
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User user = (User) principals.fromRealm(getName()).iterator().next(); 
		 String username = user.getUsername(); 
	        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();  
	        authorizationInfo.setRoles(userService.findRoles(username));  
	        authorizationInfo.setStringPermissions(userService.findPermissions(username));  
	        return authorizationInfo;  
	}

	//身份验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		 String username = (String)token.getPrincipal();  
	        User user = userService.findByUsername(username);  
	        if(null == user) {  
	            throw new UnknownAccountException();//没找到帐号  
	        }  
	        if(Boolean.TRUE.equals(user.getLocked())) {  
	            throw new LockedAccountException(); //帐号锁定  
	        }  
		return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
	}
	
	
}