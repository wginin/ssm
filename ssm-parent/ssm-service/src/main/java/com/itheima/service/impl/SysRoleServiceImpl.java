package com.itheima.service.impl;

import com.itheima.dao.SysRoleDao;
import com.itheima.domain.SysRole;
import com.itheima.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/27 16:19
 * description:深圳黑马
 * version:1.0
 ******/
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public int add(SysRole role) {
        return sysRoleDao.add(role);
    }

    @Override
    public List<SysRole> list() {
        return sysRoleDao.list();
    }
}
