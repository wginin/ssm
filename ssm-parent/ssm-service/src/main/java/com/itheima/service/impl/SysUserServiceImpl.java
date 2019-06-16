package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.SysUserDao;
import com.itheima.domain.SysUser;
import com.itheima.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/26 18:12
 * description:深圳黑马
 * version:1.0
 ******/
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUser getUserByUserName(String username) {
        return sysUserDao.getUserByUserName(username);
    }


    /****
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SysUser> list(int page, int size) {
        //开启分页查询
        PageHelper.startPage(page,size);

        //调用查询
        List<SysUser> users = sysUserDao.list();

        //分装PageInfo<T>
        return new PageInfo<SysUser>(users);
    }

    /***
     * 用户增加
     * @param user
     * @return
     */
    @Override
    public int add(SysUser user) {
        return sysUserDao.add(user);
    }

    @Override
    public SysUser getById(Long id) {
        return sysUserDao.getById(id);
    }

    /****
     * 修改用户角色
     * @param userId
     * @param ids
     * @return
     */
    @Override
    public int updateUserRole(Long userId, List<Long> ids) {
        //4.4)删除该用户之前所拥有的所有角色
        int count =sysUserDao.deleteUserRoles(userId);

        //4.5)增加新的角色信息
        for (Long id : ids) {
            //增加角色---用户角色中间表[USERID、ROLEID]
            count+=sysUserDao.addUserRole(userId,id);
        }
        return count;
    }
}
