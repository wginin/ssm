package com.itheima.service.impl;

import com.itheima.dao.SysPermissionDao;
import com.itheima.domain.SysPermission;
import com.itheima.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/27 16:48
 * description:深圳黑马
 * version:1.0
 ******/
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Override
    public List<SysPermission> list() {
        return sysPermissionDao.list();
    }

    @Override
    public int add(SysPermission permission) {
        return sysPermissionDao.add(permission);
    }
}
