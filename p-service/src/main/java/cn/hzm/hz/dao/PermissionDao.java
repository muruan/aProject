package cn.hzm.hz.dao;

import cn.hzm.hz.entity.Permission;

public interface PermissionDao {

    public Permission createPermission(Permission permission);

    //删除权限
    public void deletePermission(Long permissionId);

}