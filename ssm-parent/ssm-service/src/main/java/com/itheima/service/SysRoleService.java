package com.itheima.service;

import com.itheima.domain.SysRole;

import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/27 16:19
 * description:深圳黑马
 * version:1.0
 ******/
public interface SysRoleService {
    int add(SysRole role);

    List<SysRole> list();
}
