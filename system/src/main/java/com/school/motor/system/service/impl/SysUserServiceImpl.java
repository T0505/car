package com.school.motor.system.service.impl;

import com.school.motor.system.entities.SysUser;
import com.school.motor.system.mapper.SysUserMapper;
import com.school.motor.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
@Service
public class SysUserServiceImpl implements SysUserService {
    private SysUserMapper user;
    @Autowired
    public void setUser(SysUserMapper user) {
        this.user = user;
    }

    @Override
    public List<SysUser> select(String table, Map<String, Object> map, String... columns) {
        return user.select(table,map,columns);
    }

    @Override
    public int insert(SysUser sysUser) {
        return user.insert(sysUser);
    }

    @Override
    public int delete(String table, String column) {
        return user.delete(table, column);
    }

    @Override
    public int update(SysUser sysUser) {
        return user.update(sysUser);
    }

    @Override
    public SysUser login(String username) {
        return user.login(username);
    }
}
