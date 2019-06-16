package com.itheima.dao;

import com.itheima.domain.SysPermission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.omg.CORBA.INTERNAL;

import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/27 16:50
 * description:深圳黑马
 * version:1.0
 ******/
public interface SysPermissionDao {

    /***
     * ③根据角色ID查询权限信息
     * @param roleId
     * @return
     */
    @Select("select * from sys_permission sp,sys_role_permission srp where srp.permissionid=sp.id and srp.roleid=#{roleId}")
    List<SysPermission> getPermissionByRoleId(Integer roleId);

    /***
     * 集合查询
     * @return
     */
    @Select("select * from sys_permission")
    List<SysPermission> list();

    /***
     * 增加权限方法
     * @param permission
     * @return
     */

    @Insert("insert into sys_permission(id,permissionName,url,pid)values(#{id},#{permissionName},#{url},#{pid})")
    int add(SysPermission permission);
}
