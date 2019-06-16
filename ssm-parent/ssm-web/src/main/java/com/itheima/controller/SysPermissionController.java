package com.itheima.controller;

import com.itheima.domain.SysPermission;
import com.itheima.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/27 16:46
 * description:深圳黑马
 * version:1.0
 ******/
@Controller
@RequestMapping(value = "/permission")
public class SysPermissionController {

    @Autowired
    private SysPermissionService sysPermissionService;

    /***
     * 增加权限
     * @param permission
     * @return
     */
    @RequestMapping(value = "/add")
    public String add(SysPermission permission){
        int acount = sysPermissionService.add(permission);
        //添加完成返回列表页
        return "redirect:/permission/list";
    }

    /****
     * 列表查询[分页作为作业]
     * @return
     */
    @RequestMapping(value = "/list")
    public String list(Model model){
        //Service查询
        List<SysPermission> permissions = sysPermissionService.list();

        //存储到Model
        model.addAttribute("permissions",permissions);
        return "permission-list";
    }

}
