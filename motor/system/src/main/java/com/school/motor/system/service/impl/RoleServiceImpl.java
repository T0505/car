package com.school.motor.system.service.impl;

import com.school.motor.system.entities.Role;
import com.school.motor.system.service.RoleService;

import java.util.List;
import java.util.Map;

public class RoleServiceImpl implements RoleService {
    @Override
    public List<Role> select(String table, Map<String, Object> map, String... columns) {
        return null;
    }

    @Override
    public int insert(Role role) {
        return 0;
    }

    @Override
    public int delete(String table, String column) {
        return 0;
    }

    @Override
    public int update(Role role) {
        return 0;
    }
}
