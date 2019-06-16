package com.itheima.dao;

import com.itheima.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;

/********
 * author:shenkunlin
 * date:2018/8/29 16:55
 * description:深圳黑马
 * version:1.0
 ******/
public interface SysLogDao {

    /***
     * 增加日志
     * @param log
     */

    @Insert("insert into sys_log(id,visitTime,username,ip,method)values(#{id},#{visitTime},#{username},#{ip},#{method})")
    void addLog(SysLog log);
}
