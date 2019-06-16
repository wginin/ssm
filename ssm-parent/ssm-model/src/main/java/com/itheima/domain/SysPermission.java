package com.itheima.domain;

import java.io.Serializable;
import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/27 15:09
 * description:深圳黑马
 * version:1.0
 ******/
public class SysPermission implements Serializable {


    private Long id;
    private String permissionName;
    private String url;
    private Long pid;

    //一对多映射关系,父菜单有多个子菜单
    private List<SysPermission> child;

    //一个权限能授予多个角色
    private List<SysRole> roles;

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public List<SysPermission> getChild() {
        return child;
    }

    public void setChild(List<SysPermission> child) {
        this.child = child;
    }
}
