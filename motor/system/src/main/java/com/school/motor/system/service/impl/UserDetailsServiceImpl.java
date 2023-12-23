package com.school.motor.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service//系统类实现登陆功能
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
//    private UserService service;
//    private RoleService role;
//    @Autowired
//    public void setRole(RoleService role) {
//        this.role = role;
//    }
//    @Autowired
//    public void setService(UserService service) {
//        this.service = service;
//    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        com.school.motor.system.entities.User user = service.login(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        Map<String,Object> map = new HashMap<>();
//        map.put("id",user.getRoleId());
//        Role role = this.role.select("role", map).get(0);
//        //登陆角色
//        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role.getRoleName());
//        return new User(user.getUserName(), user.getUserPassword(), authorities);
//    }
}
