package com.itheima.dao;

import com.itheima.domain.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/26 18:13
 * description:深圳黑马
 * version:1.0
 ******/
public interface SysUserDao {


    /****
     * ①根据用户ID查询用户信息
     * @param id
     * @return
     */
    @Select("select * from sys_user where id=#{id}")
    /***
     * 1)调用SysRoleDao.getRoleByUserId()
     * 2)传递当前查询的id值给SysRoleDao.getRoleByUserId()
     * 3)SysRoleDao.getRoleByUserId()查询返回List<SysRole>
     * 4)List<SysRole> 是SysUser的子属性 roles
     * 5)可以把查询的结果集赋值给子属性roles
     */
    @Results(id = "sysUserResults",
            value = {
                    @Result(property = "roles",
                    column = "id",
                    many = @Many(select = "com.itheima.dao.SysRoleDao.getRoleByUserId"))
            }
    )
    SysUser getById(Long id);

    /***
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    @Select("select * from sys_user where username=#{username}")
    @ResultMap(value = "sysUserResults")
    SysUser getUserByUserName(String username);

    /***
     * 查询
     * @return
     */
    @Select("select * from sys_user")
    List<SysUser> list();

    /****
     * 增加
     * @param user
     * @return
     */

    @Insert("insert into sys_user(id,username,email,password,phoneNum,status)values(#{id},#{username},#{email},#{password},#{phoneNum},#{status})")
    int add(SysUser user);

    /***
     * 删除用户角色
     * @param userId
     * @return
     */
    @Delete("delete from sys_user_role where userid=#{userid}")
    int deleteUserRoles(Long userId);

    /***
     * 增加用户角色信息
     * @param userId
     * @param id
     * @return
     */
    @Insert("insert into sys_user_role(userid,roleid)values(#{userid},#{roleid})")
    int addUserRole(@Param("userid")Long userId, @Param("roleid") Long id);
}
