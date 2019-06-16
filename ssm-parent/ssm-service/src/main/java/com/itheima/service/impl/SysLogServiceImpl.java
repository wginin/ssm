package com.itheima.service.impl;

import com.itheima.dao.SysLogDao;
import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/********
 * author:shenkunlin
 * date:2018/8/29 16:55
 * description:深圳黑马
 * version:1.0
 ******/
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    /***
     * 增加日志
     * @param log
     */
    @Override
    public void addLog(SysLog log) {
        sysLogDao.addLog(log);
    }
}
