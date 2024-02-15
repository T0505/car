package com.school.motor.system.service.impl;

import com.school.motor.system.entities.SysRole;
import com.school.motor.system.mapper.SysRoleMapper;
import com.school.motor.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class SysRoleServiceImpl implements SysRoleService {
    private SysRoleMapper role;
    @Autowired
    private void setSysRoleService(SysRoleMapper role) {
        this.role = role;
    }
    @Override
    public List<SysRole> select(String table, Map<String, Object> map, String... columns) {
        return role.select(table, map, columns);
    }

    @Override
    public int insert(SysRole sysRole) {
        return role.insert(sysRole);
    }

    @Override
    public int delete(String table, String column) {
        return role.delete(table, column);
    }

    @Override
    public int update(SysRole sysRole) {
        return role.update(sysRole);
    }
}
