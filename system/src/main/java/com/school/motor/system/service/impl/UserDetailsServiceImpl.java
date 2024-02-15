package com.school.motor.system.service.impl;

import com.school.motor.system.entities.SysRole;
import com.school.motor.system.entities.SysUser;
import com.school.motor.system.service.SysRoleService;
import com.school.motor.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service//系统类实现登陆功能
public class UserDetailsServiceImpl implements UserDetailsService {
    private SysUserService service;
    private SysRoleService role;
    @Autowired
    public void setRole(SysRoleService role) {
        this.role = role;
    }
    @Autowired
    public void setService(SysUserService service) {
        this.service = service;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser user = service.login(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("id",user.getRoleId());
        List<SysRole> roles = this.role.select("role", map);

        List<GrantedAuthority> authorities = new ArrayList<>();
        if(roles != null && !roles.isEmpty()) {
            authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(roles.stream().map(SysRole::getRoleName).collect(Collectors.joining(",")));
        }
        //登陆角色
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
