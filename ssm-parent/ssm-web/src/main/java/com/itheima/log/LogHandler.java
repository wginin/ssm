package com.itheima.log;

import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/********
 * author:shenkunlin
 * date:2018/8/29 17:00
 * description:深圳黑马
 * version:1.0
 ******/
@Aspect
@Component
public class LogHandler {


    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    /***
     * 前置增强
     */
    @Before("execution(* com.itheima.controller.*Controller.*(..))")
    public void beferAddLog(JoinPoint jp){
        //添加日志到数据库
        logInfo(jp);
    }

    /***
     * 后置增强
     */
    @After("execution(* com.itheima.controller.*Controller.*(..))")
    public void afterAddLog(JoinPoint jp){
        //获取方法访问信息
        logInfo(jp);
    }

    /***
     * 添加日志到数据库
     * @param jp
     */
    public void logInfo(JoinPoint jp) {
        //获取方法访问信息
        Signature signature = jp.getSignature();

        //获取参数
        Object[] args = jp.getArgs();

        //访问Controller的方法名
        String methodName = signature.getName();

        //获取方法所在的类
        Class clazz = signature.getDeclaringType();

        //方法的全路径 class.getname+.+methodName
        String methodInfo = clazz.getName()+"."+methodName;

        //获取用户IP
        String ip = request.getRemoteAddr();

        //从SpringSecurity容器中获取用户信息
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        //封装JavaBean
        SysLog sysLog = new SysLog();
        sysLog.setVisitTime(new Date());
        sysLog.setIp(ip);
        sysLog.setUsername(name);
        sysLog.setMethod(methodInfo);


        //增加数据到日志数据库
        sysLogService.addLog(sysLog);
    }





}
