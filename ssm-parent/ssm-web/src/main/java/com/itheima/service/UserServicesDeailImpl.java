package com.itheima.service;

import com.itheima.domain.SysRole;
import com.itheima.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/26 17:59
 * description:深圳黑马
 * version:1.0
 ******/
@Component
public class UserServicesDeailImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    /***
     * 自定义认证类实现
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //数据库中查询用户信息
        SysUser sysUser = sysUserService.getUserByUserName(username);


        /****
         * 1)查询用户
         * 2)根据用户ID查询用户角色信息
         * 3)根据角色对用户进行授权
         * -----------------否定-----------------------
         * -----------------推荐-----------------------
         * 1)查询用户
         *    @Many
         *
         * 2)根据角色对用户进行授权
         */

        if(sysUser!=null){
            //获取用户角色
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

            for (SysRole sysRole : sysUser.getRoles()) {
                SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(sysRole.getRoleName());
                grantedAuthorities.add(grantedAuthority);
            }

            /***
             * 第1个参数：用户名
             * 第2个参数：密码
             * 第3个参数：角色信息
             */
            //return new User(username,"{noop}"+sysUser.getPassword(),grantedAuthorities);
            return new User(username,sysUser.getPassword(),grantedAuthorities);
        }

        return  null;
    }


}
