package cn.hzm.hz.mapper;

import java.util.Set;

import cn.hzm.hz.entity.User;

public interface UserRolePermissionMapper {

	User findUserByName(String username);
	Set<String> findRoles(String username);
	Set<String> findPermissions(String username);
	
}