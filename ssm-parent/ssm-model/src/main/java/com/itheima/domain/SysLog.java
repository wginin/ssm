package com.itheima.domain;

import java.util.Date;

/********
 * author:shenkunlin
 * date:2018/8/29 16:54
 * description:深圳黑马
 * version:1.0
 ******/
public class SysLog {





    private Long id;
    private Date visitTime;
    private String username;
    private String ip;
    private String method;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
