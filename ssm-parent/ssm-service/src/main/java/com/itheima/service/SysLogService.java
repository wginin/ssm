package com.itheima.service;

import com.itheima.domain.SysLog;

/********
 * author:shenkunlin
 * date:2018/8/29 16:55
 * description:深圳黑马
 * version:1.0
 ******/
public interface SysLogService {

    /***
     * 增加日志
     * @param log
     */
    void addLog(SysLog log);
}
