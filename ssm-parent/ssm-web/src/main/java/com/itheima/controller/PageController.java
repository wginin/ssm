package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/********
 * author:shenkunlin
 * date:2018/8/29 18:05
 * description:深圳黑马
 * version:1.0
 ******/
@Controller
@RequestMapping(value = "/pages")
public class PageController {

    /***
     * 主页跳转
     * @return
     */
    @RequestMapping(value = "/main")
    public String pageJump(){
        return "main";
    }
}
