package cn.hzm.hz.service;

import cn.hzm.hz.entity.Permission;

public interface PermissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}