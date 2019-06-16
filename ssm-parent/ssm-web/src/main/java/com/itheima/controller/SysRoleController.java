package com.itheima.controller;

import com.itheima.domain.SysRole;
import com.itheima.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/27 16:17
 * description:深圳黑马
 * version:1.0
 ******/
@Controller
@RequestMapping(value = "/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;


    /***
     * 角色列表
     * @return
     */
    @RequestMapping(value = "/list")
    public String list(Model model){
        //调用Service查询
        List<SysRole> roles = sysRoleService.list();

        //结果集存入Model
        model.addAttribute("roles",roles);
        return "role-list";
    }


    /****
     * 增加角色
     */
    @RequestMapping(value = "/add")
    public String add(SysRole role){
        int acount = sysRoleService.add(role);
        return "redirect:/role/list";
    }



}
