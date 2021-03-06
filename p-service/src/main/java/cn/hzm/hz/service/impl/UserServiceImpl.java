package cn.hzm.hz.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.hzm.hz.dao.UserDao;
import cn.hzm.hz.entity.User;
import cn.hzm.hz.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changePassword(Long userId, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void correlationRoles(Long userId, Long... roleIds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uncorrelationRoles(Long userId, Long... roleIds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public Set<String> findRoles(String username) {		
		return userDao.findRoles(username);
	}

	@Override
	public Set<String> findPermissions(String username) {		
		return userDao.findPermissions(username);
	}

}