package com.itheima.domain;

import java.io.Serializable;
import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/27 14:57
 * description:深圳黑马
 * version:1.0
 ******/
public class SysRole implements Serializable {
    private Integer id;
    private String roleName;
    private String roleDesc;

    //一个角色可以授予多个用户
    private List<SysUser> users;

    //一个角色可以有多个权限
    private List<SysPermission> permissions;

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public List<SysUser> getUsers() {
        return users;
    }

    public void setUsers(List<SysUser> users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
