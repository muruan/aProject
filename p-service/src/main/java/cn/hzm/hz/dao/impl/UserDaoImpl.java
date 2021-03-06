package cn.hzm.hz.dao.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.hzm.hz.dao.UserDao;
import cn.hzm.hz.entity.User;
import cn.hzm.hz.mapper.UserRolePermissionMapper;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao{

	@Resource
    private UserRolePermissionMapper urpm;
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Long userId) {
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
	public User findOne(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsername(String username) {
		return urpm.findUserByName(username);
	}

	@Override
	public Set<String> findRoles(String username) {		
		return urpm.findRoles(username);
	}

	@Override
	public Set<String> findPermissions(String username) {	
		return urpm.findPermissions(username);
	}

}