package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.SysUser;

import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/26 18:12
 * description:深圳黑马
 * version:1.0
 ******/
public interface SysUserService {

    /***
     * 根据用户名去数据库查询用户信息
     * @param username
     * @return
     */
    SysUser getUserByUserName(String username);

    /***
     * 用户分页列表
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysUser> list(int page, int size);

    /***
     * 增加用户
     * @param user
     * @return
     */
    int add(SysUser user);

    /****
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    SysUser getById(Long id);

    /***
     * 修改用户角色信息
     * @param userId
     * @param ids
     * @return
     */
    int updateUserRole(Long userId, List<Long> ids);
}
