package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.SysRole;
import com.itheima.domain.SysUser;
import com.itheima.service.SysRoleService;
import com.itheima.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/27 15:17
 * description:深圳黑马
 * version:1.0
 ******/
@Controller
@RequestMapping(value = "/user")
/*
jsr250
@RolesAllowed(value = {"ROLE_USER"})
*/
/*
* SpringSecurity自身注解
* @Secured(value ={"ROLE_USER"} )
* */
//必须得开启SpEl表达式
@PreAuthorize(value = "hasAnyRole('ROLE_USER')")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private SysRoleService sysRoleService;


    /***
     * 保存用户角色信息
     * @param userId
     * @param ids
     * @return
     */
    @RequestMapping(value = "/role/modify",method = RequestMethod.POST)
    public String modifyUserRole(Long userId,@RequestParam(value = "ids")List<Long> ids){
        //修改用户角色信息
        int mcount = sysUserService.updateUserRole(userId,ids);
        return "redirect:/user/list";
    }


    /****
     * 修改角色信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/role/modify",method = RequestMethod.GET)
    public String modifyUserRole(Long id,Model model){
        //1、获取所有角色信息
        List<SysRole> roles = sysRoleService.list();

        //2、获取用户的角色信息
        SysUser sysUser = sysUserService.getById(id);
        
        //获取所有角色并循环
        List<SysRole> userRoles = sysUser.getRoles();

        StringBuffer sbuffer = new StringBuffer();
        if(userRoles!=null && userRoles.size()>0){
            //用户的角色信息拼接
            for (SysRole userRole : userRoles) {
                sbuffer.append(userRole.getRoleName()+",");
            }
        }

        //3、数据存储到Model中
        model.addAttribute("userId",id);
        model.addAttribute("roles",roles);
        model.addAttribute("rolestr",sbuffer.toString());
        return "user-role-add";
    }

    /***
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/one")
    public String getById(Long id,Model model){
        //根据用户ID查询用户信息
        SysUser sysUser = sysUserService.getById(id);

        //存入Model
        model.addAttribute("sysUser",sysUser);
        return "user-show";
    }


    /****
     * 用户增加
     * @param user
     * @return
     */
    @RequestMapping(value = "/add")
    public String add(SysUser user){
        //将密码变成密文
        String str = user.getPassword();
        String estr = encoder.encode(str);
        user.setPassword(estr);

        int acount = sysUserService.add(user);
        return "redirect:/user/list";
    }

    /****
     * 分页列表
     * @param page
     * @param size
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public String list(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                       @RequestParam(value = "size",required = false,defaultValue = "5")int size,
                       Model model
                       ){
        //调用Service
        PageInfo<SysUser> pageInfo = sysUserService.list(page,size);

        //将数据存入Model
        model.addAttribute("pageInfo",pageInfo);

        /***
         * 获取用户信息
         */
        //获取SecurityContext
        SecurityContext securityContext = SecurityContextHolder.getContext();

        //获取授权对象:Authentication
        Authentication authentication = securityContext.getAuthentication();

        //获取用户信息封装对象:Principal
        User user = (User) authentication.getPrincipal();

        System.out.println("-------------------------Username:"+user.getUsername());


        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());

        return  "user-list";
    }


}
