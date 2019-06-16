package com.itheima.dao;

import com.itheima.domain.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/27 16:20
 * description:深圳黑马
 * version:1.0
 ******/
public interface SysRoleDao {

    /****
     * ②根据用户ID查询用户角色信息
     * @param userId
     * @return
     */
    @Select("select * from sys_role sr,sys_user_role sur where sur.roleid=sr.id and sur.userid=#{userId}")
    @Results(
            value = {
                    @Result(
                            property = "permissions",
                            column = "roleid",
                            many =@Many(select = "com.itheima.dao.SysPermissionDao.getPermissionByRoleId"))
            }
    )
    List<SysRole> getRoleByUserId(Long userId);

    /***
     * 用户增加
     * @param role
     * @return
     */

    @Insert("insert into sys_role(id,roleName,roleDesc)values(#{id},#{roleName},#{roleDesc})")
    int add(SysRole role);

    /****
     * 实现角色查询
     * @return
     */
    @Select("select * from sys_role")
    List<SysRole> list();
}
