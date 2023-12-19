package com.school.motor.system.service.impl;

import com.school.motor.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service//系统类实现登陆功能
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserService service;
    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.school.motor.system.entities.User user = service.login(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        //登陆角色
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        return new User(user.getUserName(), user.getUserPassword(), authorities);
    }
}
