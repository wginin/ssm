package com.itheima.interceptor;

import com.itheima.domain.SysPermission;
import com.itheima.domain.SysRole;
import com.itheima.domain.SysUser;
import com.itheima.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/29 17:54
 * description:深圳黑马
 * version:1.0
 ******/
public class PermissionInterceptor implements HandlerInterceptor {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取用户登录信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            //获取用户名
            String name = authentication.getName();

            if(name!=null && !"".equals(name)){
                //判断Session中是否存在菜单权限信息，如果存在，则放行，否则加载
                Object menuList = request.getSession().getAttribute("parents");
                if(menuList==null){
                    //查询用户的权限信息-只需要查询用户信息，会懒加载它的权限
                    SysUser sysUser = sysUserService.getUserByUserName(name);

                    //获取用户所有权限
                    List<SysPermission> allPermissions = new ArrayList<SysPermission>();        //存储所有权限

                    for (SysRole sysRole : sysUser.getRoles()) {
                        //获取角色权限
                        List<SysPermission> permissions = sysRole.getPermissions();

                        allPermissions.addAll(permissions);
                    }

                    //筛选顶级菜单
                    List<SysPermission> parents = getParents(allPermissions);

                    //循环寻找子节点
                    for (SysPermission parent : parents) {
                        //寻找子节点
                        getChild(parent,allPermissions);
                    }

                    //存入Request中--筛选1级菜单
                    //request.setAttribute("parents",parents);

                    //将菜单信息存入Session
                    request.getSession().setAttribute("parents",parents);
                }
            }
        }
        return true;
    }


    /***
     * 从所有菜单中找父菜单的子菜单
     * @param sysPermission     父菜单
     * @param allpermissions    所有菜单
     */
    public void getChild(SysPermission sysPermission,List<SysPermission> allpermissions){
        //存放所有子节点的集合
        List<SysPermission> allchild = new ArrayList<SysPermission>();


        //循环所有菜单，判断当前被循环的菜单是否是当前父菜单（sysPermission）的子菜单
        for (SysPermission cp : allpermissions) {
            //cp的Pid=sysPermission的ID，则表明cp是sysPermission子节点
            if(cp.getPid().longValue()==sysPermission.getId().longValue()){
                allchild.add(cp);

                //获取CP的子节点
                getChild(cp,allpermissions);
            }
        }

        //设置子节点
        sysPermission.setChild(allchild);
    }


    /***
     * 筛选顶级结点
     * @param permissions
     * @return
     */
    public List<SysPermission> getParents(List<SysPermission> permissions){
        //所有顶级菜单
        List<SysPermission> parents = new ArrayList<SysPermission>();

        for (SysPermission permission : permissions) {
            //顶级菜单
            if(permission.getPid().longValue()==0){
                parents.add(permission);
            }
        }
        return parents;
    }

}
